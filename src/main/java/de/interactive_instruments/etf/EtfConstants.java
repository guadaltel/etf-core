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
package de.interactive_instruments.etf;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

import de.interactive_instruments.CLUtils;
import de.interactive_instruments.II_Constants;
import de.interactive_instruments.SUtils;

/**
 * Constants which are used in the whole framework
 *
 * @author J. Herrmann ( herrmann <aT) interactive-instruments (doT> de )
 */
public class EtfConstants {

	private EtfConstants() {

	}

	/**
	 * PROPERTY KEYS
	 */
	public static final String ETF_PK_PREFIX = "etf.";
	public static final String ETF_TESTDOMAIN_PK = ETF_PK_PREFIX + "TestDomainDto";
	public static final String ETF_AUTHOR_PK = ETF_PK_PREFIX + "Author";
	public static final String ETF_LAST_EDITOR_PK = ETF_PK_PREFIX + "LastEditor";
	public static final String ETF_CREATION_DATE_PK = ETF_PK_PREFIX + "CreationDate";
	public static final String ETF_LAST_UPDATE_DATE_PK = ETF_PK_PREFIX + "LastUpdateDate";
	public static final String ETF_DESCRIPTION_PK = ETF_PK_PREFIX + "Description";
	public static final String ETF_VERSION_PK = ETF_PK_PREFIX + "Version";
	public static final String ETF_IMPL_STATUS_PK = ETF_PK_PREFIX + "Status";
	public static final String ETF_IGNORE_PROPERTIES_PK = ETF_PK_PREFIX + "ignore.properties";

	public static final String ETF_DATA_STORAGE_NAME = ETF_PK_PREFIX + "datastorage.name";

	public static Set<String> ETF_PROPERTY_KEYS = Collections.unmodifiableSet(
			new TreeSet<String>() {
				{
					add(ETF_TESTDOMAIN_PK);
					add(ETF_AUTHOR_PK);
					add(ETF_LAST_EDITOR_PK);
					add(ETF_CREATION_DATE_PK);
					add(ETF_LAST_UPDATE_DATE_PK);
					add(ETF_DESCRIPTION_PK);
					add(ETF_VERSION_PK);
					add(ETF_IGNORE_PROPERTIES_PK);
					add(ETF_IMPL_STATUS_PK);
				}
			});

	/**
	 * DIRECTORY KEYS
	 */
	public static final String ETF_DIR_PREFIX = "etf.";
	public static final String ETF_DATASOURCE_DIR = ETF_DIR_PREFIX + "datasource.dir";
	public static final String ETF_ATTACHMENT_DIR = ETF_DIR_PREFIX + "attachments.dir";
	public static final String ETF_TESTDRIVERS_DIR = ETF_DIR_PREFIX + "testdrivers.dir";
	public static final String ETF_PROJECTS_DIR = ETF_DIR_PREFIX + "projects.dir";
	public static final String ETF_REPORTSTYLES_DIR = ETF_DIR_PREFIX + "reportstyles.dir";
	public static final String ETF_BACKUP_DIR = ETF_DIR_PREFIX + "backup.dir";
	public static final String ETF_CURRENT_MODEL_VERSION = CLUtils.getImplVersionOrDefault(EtfConstants.class, "unknown");

	/**
	 * ETF NAMESPACE
	 */
	public static final String ETF_XMLNS = "http://www.interactive-instruments.de/etf/2.0";

	/**
	 * ETF test project property file
 	 */
	public static final String ETF_TESTPROJECT_PROPERTY_FILE_SUFFIX = ".etftp.properties";

	// Slant font by Glenn Chappell
	public static final String ETF_ASCII = "\n" +
			"    __________________\n" +
			"   / ____/_  __/ ____/\n" +
			"  / __/   / / / /_    \n" +
			" / /___  / / / __/    \n" +
			"/_____/ /_/ /_/       \n" +
			"                      \n" +
			"ETF core " + ETF_CURRENT_MODEL_VERSION + "\n";
}