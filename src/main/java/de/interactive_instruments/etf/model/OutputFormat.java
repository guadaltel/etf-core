/**
 * Copyright 2010-2017 interactive instruments GmbH
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
package de.interactive_instruments.etf.model;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import de.interactive_instruments.MediaType;
import de.interactive_instruments.properties.PropertyHolder;

/**
 *
 *
 * @author J. Herrmann ( herrmann <aT) interactive-instruments (doT> de )
 */
public interface OutputFormat extends Comparable<OutputFormat>, Parameterizable {

	/**
	 * Identifier for the OutputFormat
	 *
	 * @return
	 */
	EID getId();

	/**
	 * Name of the OutputFormat
	 *
	 * @return
	 */
	String getLabel();

	/**
	 * The media type that will be produced
	 *
	 * @return
	 */
	MediaType getMediaTypeType();

	/**
	 *
	 * @param arguments
	 * @param inputStream
	 * @param outputStreamStream
	 */
	void streamTo(final PropertyHolder arguments,
			final InputStream inputStream,
			final OutputStream outputStreamStream) throws IOException;

	@Override
	default int compareTo(final OutputFormat o) {
		return getId().compareTo(o.getId());
	}
}
