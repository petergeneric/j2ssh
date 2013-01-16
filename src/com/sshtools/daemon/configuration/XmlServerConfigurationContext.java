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
package com.sshtools.daemon.configuration;

import com.sshtools.j2ssh.configuration.ConfigurationContext;
import com.sshtools.j2ssh.configuration.ConfigurationException;
import com.sshtools.j2ssh.configuration.ConfigurationLoader;

import java.util.HashMap;


/**
 *
 *
 * @author $author$
 * @version $Revision: 1.13 $
 */
public class XmlServerConfigurationContext implements ConfigurationContext {
    HashMap configurations = new HashMap();
    String serverResource = null;
    String platformResource = null;
    boolean failOnError = true;

    /**
 * Creates a new XmlServerConfigurationContext object.
 */
    public XmlServerConfigurationContext() {
    }

    /**
 *
 *
 * @param serverResource
 */
    public void setServerConfigurationResource(String serverResource) {
        this.serverResource = serverResource;
    }

    /**
 *
 *
 * @param platformResource
 */
    public void setPlatformConfigurationResource(String platformResource) {
        this.platformResource = platformResource;
    }

    /**
 *
 *
 * @param failOnError
 */
    public void setFailOnError(boolean failOnError) {
        this.failOnError = failOnError;
    }

    /**
 *
 *
 * @throws ConfigurationException
 */
    public void initialize() throws ConfigurationException {
        if (serverResource != null) {
            try {
                ServerConfiguration y = new ServerConfiguration(ConfigurationLoader.loadFile(
                            serverResource));
                configurations.put(ServerConfiguration.class, y);
            } catch (Exception ex) {
                if (failOnError) {
                    throw new ConfigurationException(ex.getMessage());
                }
            }
        }

        if (platformResource != null) {
            try {
                PlatformConfiguration z = new PlatformConfiguration(ConfigurationLoader.loadFile(
                            platformResource));
                configurations.put(PlatformConfiguration.class, z);
            } catch (Exception ex) {
                if (failOnError) {
                    throw new ConfigurationException(ex.getMessage());
                }
            }
        }
    }

    /**
 *
 *
 * @param cls
 *
 * @return
 */
    public boolean isConfigurationAvailable(Class cls) {
        return configurations.containsKey(cls);
    }

    /**
 *
 *
 * @param cls
 *
 * @return
 *
 * @throws ConfigurationException
 */
    public Object getConfiguration(Class cls) throws ConfigurationException {
        if (configurations.containsKey(cls)) {
            return configurations.get(cls);
        } else {
            throw new ConfigurationException(cls.getName() +
                " configuration not available");
        }
    }
}
