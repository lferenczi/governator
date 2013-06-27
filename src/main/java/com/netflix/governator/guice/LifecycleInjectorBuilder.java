/*
 * Copyright 2013 Netflix, Inc.
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

import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.Stage;

import java.util.Collection;

/**
 * Builder for a {@link LifecycleInjector}
 */
public interface LifecycleInjectorBuilder
{
    /**
     * Specify a bootstrap module
     *
     * @param module the module
     * @return this
     */
    public LifecycleInjectorBuilder withBootstrapModule(BootstrapModule module);

    /**
     * Specify standard Guice modules for the main binding phase
     *
     * @param modules modules
     * @return this
     */
    public LifecycleInjectorBuilder withModules(Module... modules);

    /**
     * Specify standard Guice modules for the main binding phase
     *
     * @param modules modules
     * @return this
     */
    public LifecycleInjectorBuilder withModules(Iterable<? extends Module> modules);

    /**
     * Add to any modules already specified via {@link #withModules(Iterable)}
     *
     * @param modules modules
     * @return this
     */
    public LifecycleInjectorBuilder withAdditionalModules(Iterable<? extends Module> modules);

    /**
     * Add to any modules already specified via {@link #withModules(Iterable)}
     *
     * @param modules modules
     * @return this
     */
    public LifecycleInjectorBuilder withAdditionalModules(Module... modules);

    /**
     * Set the Guice stage - the default is Production
     *
     * @param stage new stage
     * @return this
     */
    public LifecycleInjectorBuilder inStage(Stage stage);

    /**
     * Build and return the injector
     *
     * @return LifecycleInjector
     */
    public LifecycleInjector build();

    /**
     * Internally build the LifecycleInjector and then return the result of calling
     * {@link LifecycleInjector#createInjector()}
     *
     * @return Guice injector
     */
    public Injector createInjector();
}
