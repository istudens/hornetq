/*
 * Copyright 2014 Red Hat, Inc.
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

package org.hornetq.tests.secman;

import org.hornetq.utils.HornetQThreadFactory;
import org.junit.Test;

import java.security.AccessControlException;
import java.util.concurrent.ThreadFactory;

import static org.junit.Assert.fail;

/**
 * @author <a href="mailto:istudens@redhat.com">Ivo Studensky</a>.
 */
public class ThreadFactoryUnitTest
{

   private Exception failed;

   /**
    */
   @Test
   public void testWithNullProtectionDomain() throws Exception
   {
      Thread thread = new sun.misc.InnocuousThread(new Runnable()
      {
         @Override
         public void run()
         {
            ThreadFactory factory = new HornetQThreadFactory("HornetQ-secman-test-pool" + System.identityHashCode(this),
                  false,
                  this.getClass().getClassLoader());

            Thread t = factory.newThread(new Runnable()
            {
               @Override
               public void run()
               {
                  try
                  {
                     System.getProperty("java.home");
                  }
                  catch (AccessControlException e)
                  {
                     failed = e;
                  }
               }
            });
            t.start();
            try
            {
               t.join();
            }
            catch (InterruptedException e)
            {
               e.printStackTrace();
            }
         }
      });
      failed = null;

      thread.start();
      thread.join();

      if (failed != null)
      {
         fail("Could not read a system property!");
      }
      failed = null;
   }

}
