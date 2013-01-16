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
import java.io.InputStreamReader;
import com.sshtools.j2ssh.SshClient;
import com.sshtools.j2ssh.authentication.AuthenticationProtocolState;
import com.sshtools.j2ssh.authentication.PasswordAuthenticationClient;
import com.sshtools.j2ssh.forwarding.ForwardingClient;
import com.sshtools.j2ssh.transport.TransportProtocolState;
import com.sshtools.j2ssh.configuration.ConfigurationLoader;
/*import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;*/
/**
 * Demonstrates a starting both a local and remote forwarding configuration.
 *
 * @author <A HREF="mailto:lee@sshtools.com">Lee David Painter</A>
 * @version $Id: PortForwarding.java,v 1.9 2003/07/16 10:42:07 t_magicthize Exp $
 *
 * @created 20 December 2002
 */
public class PortForwarding {
  /**
   * The main program for the PortForwarding class
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
      BufferedReader reader =
          new BufferedReader(new InputStreamReader(System.in));
      System.out.print("Connect to host? ");
      String hostname = reader.readLine();
      // Make a client connection
      SshClient ssh = new SshClient();
      // Connect to the hos
      ssh.connect(hostname);
      // Create a password authentication instance
      PasswordAuthenticationClient pwd = new PasswordAuthenticationClient();
      // Get the users name
      System.out.print("Username? ");
      String username = reader.readLine();
      pwd.setUsername(username);
      // Get the password
      System.out.print("Password? ");
      String password = reader.readLine();
      pwd.setPassword(password);
      // Try the authentication
      int result = ssh.authenticate(pwd);
      // Evaluate the result
      if (result == AuthenticationProtocolState.COMPLETE) {
        ForwardingClient forwarding = ssh.getForwardingClient();
        forwarding.addLocalForwarding("Test Local", "0.0.0.0", 8081,
                                      "127.0.0.1", 80);
        forwarding.startLocalForwarding("Test Local");
        forwarding.addRemoteForwarding("Test Remote", "0.0.0.0", 8081,
                                       "127.0.0.1", 8080);
        forwarding.startRemoteForwarding("Test Remote");
      }
      ssh.getConnectionState().waitForState(TransportProtocolState.DISCONNECTED);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}
