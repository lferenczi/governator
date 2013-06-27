/*
 * Copyright 2012 Netflix, Inc.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.netflix.governator.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Scopes;
import com.netflix.governator.guice.mocks.SimplePojo;
import com.netflix.governator.guice.mocks.SimplePojoAlt;
import com.netflix.governator.guice.mocks.SimpleProvider;
import com.netflix.governator.guice.mocks.SimpleProviderAlt;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestGovernatorGuice
{
    private static final String PACKAGES = "com.netflix.governator.guice.mocks";

    @Test
    public void     testSimpleProvider() throws Exception
    {
        Injector                injector = Guice.createInjector
        (
            new AbstractModule()
            {
                @Override
                protected void configure()
                {
                    ProviderBinderUtil.bind(binder(), SimpleProvider.class, Scopes.SINGLETON);
                    ProviderBinderUtil.bind(binder(), SimpleProviderAlt.class, Scopes.SINGLETON);
                }
            }
        );

        SimplePojo pojo = injector.getInstance(SimplePojo.class);
        Assert.assertEquals(pojo.getI(), 1);
        Assert.assertEquals(pojo.getS(), "one");

        SimplePojoAlt pojoAlt = injector.getInstance(SimplePojoAlt.class);
        Assert.assertEquals(pojoAlt.getL(), 3);
        Assert.assertEquals(pojoAlt.getD(), 4.5);
    }

}
