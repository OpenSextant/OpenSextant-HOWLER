package org.opensextant.howler.test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.tinkerpop.gremlin.structure.Graph;
import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.opensextant.howler.convertors.Howler;
import org.opensextant.howler.convertors.SPOConverterGraph;
import org.opensextant.howler.spo.Document;

import com.steelbridgelabs.oss.neo4j.structure.Neo4JElementIdProvider;
import com.steelbridgelabs.oss.neo4j.structure.Neo4JGraph;
import com.steelbridgelabs.oss.neo4j.structure.providers.Neo4JNativeElementIdProvider;

public class GraphTest {

  public static void main(String[] args) throws IOException {

    String props = args[0];
    File test = new File(args[1]);
    String neoURL = args[2];
    String username = args[3];
    String password = args[4];

    // create the base Howler
    Howler howler = new Howler(props);

    // get a TinkerPop graph (here we use Neo4J )
    Graph gr = getNeo(neoURL, username, password);

    // create a graph converter which will populate the TinkerPop graph
    SPOConverterGraph grapher = new SPOConverterGraph(gr);

    String title = "Test Text";

    // read in the individual lines
    List<String> lines = FileUtils.readLines(test);

    // convert each line
    for (String text : lines) {

      // skip comments
      if (text.startsWith("//")) {
        continue;
      }

      // convert text to a Howler document
      Document doc = howler.convertText(title, text);

      // convert document to nodes and edges and add to graph
      grapher.addDocument(doc);

    }

    // optionally link graph nodes which mention each other across sentences
    // using the nxn approach
    // grapher.addMentions_N2();

    // using the keyword approach
    grapher.addMentions_Keys();
  }

  // convenience method to get a Neo4J flavor of a TinkerPop graph
  private static Graph getNeo(String url, String username, String password) {

    // get a connection to the Neo4j instance
    Driver driver = GraphDatabase.driver(url, AuthTokens.basic(username, password));
    
    // the stuff the creates the IDs for vertices and edges
    Neo4JElementIdProvider<Long> vertexIdProvider = new Neo4JNativeElementIdProvider();
    Neo4JElementIdProvider<Long> edgeIdProvider = new Neo4JNativeElementIdProvider();

    // create Tinkerpop graph instance from the Neo4j instance
    return new Neo4JGraph(driver, vertexIdProvider, edgeIdProvider);
  }

}
