/**
 * Copyright 2010-2016 interactive instruments GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.interactive_instruments.etf.testdriver;

import de.interactive_instruments.Configurable;
import de.interactive_instruments.Releasable;
import de.interactive_instruments.etf.component.ComponentInfo;
import de.interactive_instruments.etf.dal.dto.capabilities.TestObjectTypeDto;
import de.interactive_instruments.etf.dal.dto.run.TestTaskDto;
import de.interactive_instruments.etf.dal.dto.test.ExecutableTestSuiteDto;
import de.interactive_instruments.exceptions.config.ConfigurationException;

import java.util.Collection;

/**
 * Test Driver
 *
 * @author J. Herrmann ( herrmann <aT) interactive-instruments (doT> de )
 */
public interface TestDriver extends Configurable, Releasable {

	/**
	 * Returns a collection of all Executable Test Suits
	 *
	 * @return collection of Executable Test Suits
	 */
	Collection<ExecutableTestSuiteDto> getExecutableTestSuites();

	/**
	 * Returns a collection of supported Test Object Types
	 *
	 * @return collection of Test Object Types
	 */
	Collection<TestObjectTypeDto> getTestObjectTypes();

	/**
	 * Returns the Test Driver's component information
	 *
	 * @return Test Driver component information
	 */
	ComponentInfo getInfo();

	/**
	 * Requests the Test Driver to give information about unknown ETS
	 *
	 * @param etsLookupRequest ETS holding object
	 */
	void lookupExecutableTestSuites(final EtsLookupRequest etsLookupRequest);

	/**
	 * Creates a new Test Task
	 *
	 * @param testTaskDto Test Task Dto
	 * @return
	 */
	TestTask createTestTask(final TestTaskDto testTaskDto) throws ConfigurationException;
}