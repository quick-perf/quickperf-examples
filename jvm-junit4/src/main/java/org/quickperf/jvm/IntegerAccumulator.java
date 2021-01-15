/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2020-2021 the original author or authors.
 */

package org.quickperf.jvm;

import java.util.ArrayList;
import java.util.List;

public class IntegerAccumulator {

    private List<Integer> integerList;

    public void accumulateInteger(int numberOfIntegers) {
        integerList = new ArrayList<>(numberOfIntegers);
        for (int i = 1; i <= numberOfIntegers; i++) {
            integerList.add(i);
        }
    }

    public int getSize() {
        if(integerList == null) {
            return 0;
        }
        return integerList.size();
    }

}
