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

package org.hornetq.integration.bootstrap;

import org.jboss.logging.BasicLogger;
import org.jboss.logging.Logger;
import org.jboss.logging.annotations.Cause;
import org.jboss.logging.annotations.LogMessage;
import org.jboss.logging.annotations.Message;
import org.jboss.logging.annotations.MessageLogger;

/**
 * @author <a href="mailto:andy.taylor@jboss.org">Andy Taylor</a>
 *         3/15/12
 *
 * Logger Code 10
 *
 * each message id must be 6 digits long starting with 10, the 3rd digit donates the level so
 *
 * INF0  1
 * WARN  2
 * DEBUG 3
 * ERROR 4
 * TRACE 5
 * FATAL 6
 *
 * so an INFO message would be 101000 to 101999
 */
@MessageLogger(projectCode = "HQ")
public interface HornetQBootstrapLogger extends BasicLogger
{
   /**
    * The default logger.
    */
   HornetQBootstrapLogger LOGGER = Logger.getMessageLogger(HornetQBootstrapLogger.class, HornetQBootstrapLogger.class.getPackage().getName());

   @LogMessage(level = Logger.Level.INFO)
   @Message(id = 101000, value = "Starting HornetQ Server", format = Message.Format.MESSAGE_FORMAT)
   void serverStarting();

   @LogMessage(level = Logger.Level.INFO)
   @Message(id = 101001, value = "Stopping HornetQ Server", format = Message.Format.MESSAGE_FORMAT)
   void serverStopping();

   @LogMessage(level = Logger.Level.WARN)
   @Message(id = 102000, value = "Error during undeployment: {0}", format = Message.Format.MESSAGE_FORMAT)
   void errorDuringUndeployment(@Cause Throwable t, String name);

   @LogMessage(level = Logger.Level.ERROR)
   @Message(id = 104000, value = "Failed to delete file {0}", format = Message.Format.MESSAGE_FORMAT)
   void errorDeletingFile(String name);

   @LogMessage(level = Logger.Level.ERROR)
   @Message(id = 104001, value = "Failed to start server", format = Message.Format.MESSAGE_FORMAT)
   void errorStartingServer(@Cause Exception e);
}
