/*
 * Copyright 2005-2014 Red Hat, Inc.
 * Red Hat licenses this file to you under the Apache License, version
 * 2.0 (the "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.  See the License for the specific language governing
 * permissions and limitations under the License.
 */
package org.hornetq.core.config;

import org.hornetq.api.config.HornetQDefaultConfiguration;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ScaleDownConfiguration implements Serializable
{
   private List<String> connectors = new ArrayList<>();

   private String discoveryGroup = null;

   private String groupName = null;

   private String clusterName = null;

   private boolean scaleDown = HornetQDefaultConfiguration.isDefaultScaleDown();

   public List<String> getConnectors()
   {
      return connectors;
   }

   public ScaleDownConfiguration setConnectors(List<String> connectors)
   {
      this.connectors = connectors;
      return this;
   }

   public ScaleDownConfiguration addConnector(String connector)
   {
      connectors.add(connector);
      return this;
   }

   public String getDiscoveryGroup()
   {
      return discoveryGroup;
   }

   public ScaleDownConfiguration setDiscoveryGroup(String discoveryGroup)
   {
      this.discoveryGroup = discoveryGroup;
      return this;
   }

   public String getGroupName()
   {
      return groupName;
   }

   public ScaleDownConfiguration setGroupName(String groupName)
   {
      this.groupName = groupName;
      return this;
   }

   public String getClusterName()
   {
      return clusterName;
   }

   public ScaleDownConfiguration setClusterName(String clusterName)
   {
      this.clusterName = clusterName;
      return this;
   }

   public boolean isScaleDown()
   {
      return scaleDown;
   }

   public ScaleDownConfiguration setScaleDown(boolean scaleDown)
   {
      this.scaleDown = scaleDown;
      return this;
   }
}
