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
package com.sshtools.j2ssh.transport.publickey.dsa;

import com.sshtools.j2ssh.configuration.ConfigurationLoader;
import com.sshtools.j2ssh.transport.publickey.InvalidSshKeyException;
import com.sshtools.j2ssh.transport.publickey.SshKeyPair;
import com.sshtools.j2ssh.transport.publickey.SshPrivateKey;
import com.sshtools.j2ssh.transport.publickey.SshPublicKey;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.DSAPrivateKey;
import java.security.interfaces.DSAPublicKey;


/**
 *
 *
 * @author $author$
 * @version $Revision: 1.17 $
 */
public class SshDssKeyPair extends SshKeyPair {
    /**
     *
     *
     * @param encoded
     *
     * @return
     *
     * @throws InvalidSshKeyException
     */
    public SshPrivateKey decodePrivateKey(byte[] encoded)
        throws InvalidSshKeyException {
        return new SshDssPrivateKey(encoded);
    }

    /**
     *
     *
     * @param encoded
     *
     * @return
     *
     * @throws InvalidSshKeyException
     */
    public SshPublicKey decodePublicKey(byte[] encoded)
        throws InvalidSshKeyException {
        return new SshDssPublicKey(encoded);
    }

    /**
     *
     *
     * @param bits
     */
    public void generate(int bits) {
        try {
            // Initialize the generator
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA");
            keyGen.initialize(bits, ConfigurationLoader.getRND());

            KeyPair pair = keyGen.generateKeyPair();

            // Get the keys
            DSAPrivateKey prvKey = (DSAPrivateKey) pair.getPrivate();
            DSAPublicKey pubKey = (DSAPublicKey) pair.getPublic();

            // Set the private key (the public is automatically generated)
            setPrivateKey(new SshDssPrivateKey(prvKey));
        } catch (NoSuchAlgorithmException nsae) {
        }
    }
}
