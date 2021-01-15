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

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.quickperf.junit5.QuickPerfTest;
import org.quickperf.jvm.allocation.AllocationUnit;
import org.quickperf.jvm.annotations.ExpectNoHeapAllocation;
import org.quickperf.jvm.annotations.HeapSize;
import org.quickperf.jvm.annotations.JvmOptions;
import org.quickperf.jvm.annotations.MeasureHeapAllocation;
import org.quickperf.jvm.jfr.annotation.ExpectNoJvmIssue;
import org.quickperf.jvm.jfr.annotation.ProfileJvm;

import java.util.ArrayList;

@QuickPerfTest
public class JvmAnnotationsJunit5Test {

    @MeasureHeapAllocation
    //@ExpectMaxHeapAllocation(value = 440, unit = AllocationUnit.BYTE)
    @Test
    public void test_method_measuring_heap_allocation() {
        // java.util.ArrayList: 24 bytes
        //            +
        //  Object[]: 16 + 100 x 4 = 416
        //  = 440 bytes
        ArrayList<Object> data = new ArrayList<>(100);
    }

    @ExpectNoHeapAllocation
    @Test
    public void should_not_allocate() {
        // If you uncomment the line below the test will fail
        // new Object();
    }

    @ProfileJvm
    @HeapSize(value = 50, unit = AllocationUnit.MEGA_BYTE)
    @Test
    public void should_accumulate_integers_between_0_and_1_000_000() {

        // Given
        IntegerAccumulator integerAccumulator = new IntegerAccumulator();

        // When
        integerAccumulator.accumulateInteger(1_000_000);

        // Then
        Assertions.assertEquals(1_000_000, integerAccumulator.getSize());

    }

    @ExpectNoJvmIssue
    @HeapSize(value = 50, unit = AllocationUnit.MEGA_BYTE)
    @JvmOptions("-XX:FlightRecorderOptions=stackdepth=128")
    @Test
    public void expect_no_jvm_issue_with_accumulation_of_integers_between_0_and_1_000_000() {

        IntegerAccumulator integerAccumulator = new IntegerAccumulator();

        integerAccumulator.accumulateInteger(1_000_000);

    }

}
