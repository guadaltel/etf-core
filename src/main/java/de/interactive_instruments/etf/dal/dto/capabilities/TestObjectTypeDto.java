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
package de.interactive_instruments.etf.dal.dto.capabilities;

import java.util.ArrayList;
import java.util.List;

import de.interactive_instruments.etf.dal.dto.MetaDataItemDto;

public class TestObjectTypeDto extends MetaDataItemDto {
	protected List<TestObjectTypeDto> subTypes;

	public List<TestObjectTypeDto> getSubTypes() {
		return subTypes;
	}

	public void setSubTypes(final List<TestObjectTypeDto> subTypes) {
		this.subTypes = subTypes;
	}

	public void addSubType(final TestObjectTypeDto subType) {
		if (this.subTypes == null) {
			subTypes = new ArrayList<>();
		}
		subTypes.add(subType);
	}
}
