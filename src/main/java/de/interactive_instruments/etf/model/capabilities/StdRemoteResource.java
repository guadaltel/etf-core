/**
 * Copyright 2017-2018 European Union, interactive instruments GmbH
 * Licensed under the EUPL, Version 1.2 or - as soon they will be approved by
 * the European Commission - subsequent versions of the EUPL (the "Licence");
 * You may not use this work except in compliance with the Licence.
 * You may obtain a copy of the Licence at:
 *
 * https://joinup.ec.europa.eu/software/page/eupl
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the Licence is distributed on an "AS IS" basis,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Licence for the specific language governing permissions and
 * limitations under the Licence.
 *
 * This work was supported by the EU Interoperability Solutions for
 * European Public Administrations Programme (http://ec.europa.eu/isa)
 * through Action 1.17: A Reusable INSPIRE Reference Platform (ARE3NA).
 */
package de.interactive_instruments.etf.model.capabilities;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Map;

import de.interactive_instruments.UriModificationCheck;
import de.interactive_instruments.UriUtils;

/**
 * @author Jon Herrmann ( herrmann aT interactive-instruments doT de )
 */
public class StdRemoteResource implements RemoteResource {

	private final String name;
	// Not exposed
	private URI uri;
	private UriModificationCheck check;

	public StdRemoteResource(final String name, final URI uri) {
		this.name = name;
		this.uri = UriUtils.sortQueryParameters(uri);
	}

	public StdRemoteResource(final String name, final String uri) {
		this.name = name;
		this.uri = URI.create(UriUtils.sortQueryParameters(uri));
	}

	public StdRemoteResource(final Resource other) {
		this(other.getName(), other.getUri());
		// do not copy check
	}

	public StdRemoteResource(final StdRemoteResource other) {
		this.name = other.name;
		this.uri = other.uri;
		// do not copy check
	}

	/**
	 * Returns true if the parameter changed
	 *
	 * @param kvp Key value pair map
	 * @return true if URI changed, false otherwise
	 */
	boolean setQueyParameters(final Map<String, String> kvp) {
		final URI newUri = URI.create(UriUtils.setQueryParameters(uri.toString(),
				kvp, true));
		if (!newUri.equals(uri)) {
			uri = newUri;
			if (check != null) {
				try {
					check = new UriModificationCheck(uri, null);
				} catch (IOException e) {
					check = null;
				}
			}
			return true;
		}
		return false;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public URI getUri() {
		return uri;
	}

	@Override
	public long getContentLength() throws IOException {
		return UriUtils.getContentLength(uri, null);
	}

	@Override
	public InputStream openStream() throws IOException {
		return UriUtils.openStream(uri, null);
	}

	@Override
	public InputStream openStream(final int timeout) throws IOException {
		return UriUtils.openStream(uri, null, timeout);
	}

	@Override
	public byte[] getBytes() throws IOException {
		return UriUtils.toByteArray(uri, null);
	}

	@Override
	public byte[] getBytes(final int timeout) throws IOException {
		return UriUtils.toByteArray(uri, null, timeout);
	}

	@Override
	public boolean exists() {
		return UriUtils.exists(uri, null);
	}

	@Override
	public UriModificationCheck getModificationCheck() throws IOException {
		if (check == null) {
			check = new UriModificationCheck(uri, null);
		}
		return check;
	}

	public boolean isModificationCheckInitialized() {
		return check != null;
	}

	@Override
	public void release() {
		check = null;
	}

	@Override
	public StdRemoteResource createCopy() {
		return new StdRemoteResource(this);
	}
}
