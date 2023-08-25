package com.beancurdv.buildsrc;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

/**
 * GreetingV2
 *
 * @author beancurdv on 2023/8/25
 */
public class GreetingPluginV2 implements Plugin<Project> {
    @Override
    public void apply(Project target) {
        X x = new X();


        System.out.println("hello world : " + x.getM());
    }
}
