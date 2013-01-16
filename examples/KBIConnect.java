/*
 *  SSHTools - Java SSH2 API
 *
 *  Copyright (C) 2002-2003 Lee David Painter and Contributors.
 *
 *  Contributions made by:
 *
 *  Brett Smith
 *  Richard Pernavas
 *  Erwin Bolwidt
 *
 *  This program is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU General Public License
 *  as published by the Free Software Foundation; either version 2
 *  of the License, or (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program; if not, write to the Free Software
 *  Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import com.sshtools.j2ssh.SshClient;
import com.sshtools.j2ssh.authentication.AuthenticationProtocolState;
import com.sshtools.j2ssh.authentication.KBIAuthenticationClient;
import com.sshtools.j2ssh.authentication.KBIPrompt;
import com.sshtools.j2ssh.authentication.KBIRequestHandler;
import com.sshtools.j2ssh.configuration.ConfigurationLoader;
import com.sshtools.j2ssh.configuration.SshConnectionProperties;
import com.sshtools.j2ssh.io.IOStreamConnector;
import com.sshtools.j2ssh.io.IOStreamConnectorState;
import com.sshtools.j2ssh.session.SessionChannelClient;
/*import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;*/
/**
 * Demonstrates a simple password connection to an SSH server.
 *
 * @author <A HREF="mailto:lee@sshtools.com">Lee David Painter</A>
 * @version $Id: KBIConnect.java,v 1.8 2003/07/16 10:42:07 t_magicthize Exp $
 *
 * @created 20 December 2002
 */
public class KBIConnect {
  private static BufferedReader reader =
      new BufferedReader(new InputStreamReader(System.in));
  /**
   * The main program for the PasswordConnect class
   *
   * @param args The command line arguments
   */
  public static void main(String args[]) {
    try {
      // Setup a logfile
      /*Handler fh = new FileHandler("example.log");
      fh.setFormatter(new SimpleFormatter());
      Logger.getLogger("com.sshtools").setUseParentHandlers(false);
      Logger.getLogger("com.sshtools").addHandler(fh);
      Logger.getLogger("com.sshtools").setLevel(Level.ALL);*/
      // Configure J2SSH (This will attempt to install the bouncycastle provider
      // under jdk 1.3.1)
      ConfigurationLoader.initialize(false);
      System.out.print("Connect to host? ");
      System.out.print("Connect to host? ");
      String hostname = reader.readLine();
      // Make a client connection
      SshClient ssh = new SshClient();
      SshConnectionProperties properties = new SshConnectionProperties();
      properties.setHost(hostname);
      // Connect to the host
      ssh.connect(properties);
      // Create a password authentication instance
      KBIAuthenticationClient kbi = new KBIAuthenticationClient();
      // Get the users name
      System.out.print("Username? ");
      // Read the password
      String username = reader.readLine();
      kbi.setUsername(username);
      kbi.setKBIRequestHandler(new KBIRequestHandler() {
        public void showPrompts(String name, String instructions,
                                KBIPrompt[] prompts) {
          System.out.println(name);
          System.out.println(instructions);
          String response;
          if (prompts != null) {
            for (int i = 0; i < prompts.length; i++) {
              System.out.print(prompts[i].getPrompt() + ": ");
              try {
                response = reader.readLine();
                prompts[i].setResponse(response);
              }
              catch (IOException ex) {
                prompts[i].setResponse("");
                ex.printStackTrace();
              }
            }
          }
        }
      });
      // Try the authentication
      int result = ssh.authenticate(kbi);
      // Evaluate the result
      if (result == AuthenticationProtocolState.COMPLETE) {
        // The connection is authenticated we can now do some real work!
        SessionChannelClient session = ssh.openSessionChannel();
        if(!session.requestPseudoTerminal("vt100", 80, 24, 0, 0, ""))
          System.out.println("Failed to allocate a pseudo terminal");
        if(session.startShell()) {
          IOStreamConnector input =
              new IOStreamConnector(System.in, session.getOutputStream());
          IOStreamConnector output =
              new IOStreamConnector(session.getInputStream(), System.out);
          output.getState().waitForState(IOStreamConnectorState.CLOSED);
        }else
          System.out.println("Failed to start the users shell");
        ssh.disconnect();
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}
