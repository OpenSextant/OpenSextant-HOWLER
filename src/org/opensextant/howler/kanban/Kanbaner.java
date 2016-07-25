/*
 * **************************************************************************
 *					     NOTICE
 *
 *	This software was produced for the U. S. Government
 *	under Basic Contract No. W15P7T-13-C-A802, and is
 *	subject to the Rights in Noncommercial Computer Software
 *	and Noncommercial Computer Software Documentation
 *	Clause 252.227-7014 (FEB 2012)
 *
 *  2016 The MITRE Corporation. All Rights Reserved.
 *
 * **************************************************************************
 */
package org.opensextant.howler.kanban;

import org.opensextant.howler.convertors.Howler;

public class Kanbaner {

  public static void main(String[] args) {

    String configPath = args[0];

    Howler howler = new Howler(configPath);

    // create a Kanban with a Howler and a config file
    Kanban kanban = new Kanban(howler, configPath);

    // start the kanban
    kanban.start();

  }
}
