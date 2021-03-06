/*
 * Copyright 2017 W.UP Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package digital.wup.android_maven_publish

import org.gradle.api.internal.project.ProjectInternal
import spock.lang.Specification

abstract class AbstractProjectBuilderSpec extends Specification {

    protected File root

    protected ProjectInternal project
    private static int testFolderId = 0;

    def setup() {
        root = new File("build/tmp/test-app${testFolderId++}")
        root.mkdirs()
        cleanFolder(root)
        project = TestUtil.createRootProject(root)
    }

    static void cleanFolder(File folder) {
        File[] files = folder.listFiles();
        if (files != null) { //some JVMs return null for empty dirs
            for (File f : files) {
                if (f.isDirectory()) {
                    cleanFolder(f);
                } else {
                    f.delete();
                }
            }
        }
    }
}
