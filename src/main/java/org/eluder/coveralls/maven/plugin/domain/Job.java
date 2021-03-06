package org.eluder.coveralls.maven.plugin.domain;

import java.util.Date;

/*
 * #[license]
 * coveralls-maven-plugin
 * %%
 * Copyright (C) 2013 Tapio Rautonen
 * %%
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * %[license]
 */

public class Job {

    private String repoToken;
    private String serviceName;
    private String serviceJobId;
    private Date timestamp;
    private Git git;
    
    public Job() {
        // noop
    }
    
    /**
     * @deprecated Will be removed in 2.0.0, use default constructor and with* methods
     */
    @Deprecated
    public Job(final String repoToken, final String serviceName, final String serviceJobId, final Git git) {
        this.repoToken = repoToken;
        this.serviceName = serviceName;
        this.serviceJobId = serviceJobId;
        this.git = git;
    }

    public Job withRepoToken(final String repoToken) {
        this.repoToken = repoToken;
        return this;
    }
    
    public Job withServiceName(final String serviceName) {
        this.serviceName = serviceName;
        return this;
    }
    
    public Job withServiceJobId(final String serviceJobId) {
        this.serviceJobId = serviceJobId;
        return this;
    }
    
    public Job withTimestamp(final Date timestamp) {
        this.timestamp = timestamp;
        return this;
    }
    
    public Job withGit(final Git git) {
        this.git = git;
        return this;
    }
    
    public String getRepoToken() {
        return repoToken;
    }
    
    public String getServiceName() {
        return serviceName;
    }
    
    public String getServiceJobId() {
        return serviceJobId;
    }
    
    public Date getTimestamp() {
        return timestamp;
    }
    
    public Git getGit() {
        return git;
    }
}
