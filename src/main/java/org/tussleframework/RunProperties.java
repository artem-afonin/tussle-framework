/*
 * Copyright (c) 2021, Azul Systems
 * 
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * 
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 * 
 * * Neither the name of [project] nor the names of its
 *   contributors may be used to endorse or promote products derived from
 *   this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * 
 */

package org.tussleframework;

import java.util.HashMap;
import java.util.Properties;

public class RunProperties extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public synchronized void setProperty(String key, Object o) {
        put(key, o);
    }

    public synchronized String getProperty(String key) {
        Object o = get(key);
        return o != null ? o.toString() : null;
    }

    public synchronized Properties getPropMap(String key) {
        Properties[] prop = (Properties[]) get(key);
        if (prop == null) {
            prop = new Properties[1];
            prop[0] = new Properties();
            put(key, prop);
        }
        return prop[0];
    }

    public synchronized Properties getHardware() {
        return getPropMap("hardwareInfo");
    }

    public synchronized Properties getOs() {
        return getPropMap("osInfo");
    }

    public synchronized Properties getJvm() {
        return getPropMap("jvmInfo");
    }
}
