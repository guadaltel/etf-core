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
package de.interactive_instruments.etf.dal.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import de.interactive_instruments.Configurable;
import de.interactive_instruments.IFile;
import de.interactive_instruments.Releasable;
import de.interactive_instruments.etf.dal.dto.Dto;
import de.interactive_instruments.exceptions.StoreException;

/**
 * DataStorage managed by the DataStorageManager
 *
 * @author J. Herrmann ( herrmann <aT) interactive-instruments (doT> de )
 */
public interface DataStorage extends Configurable, Releasable {

	/**
	 * Reset the data storage
	 *
	 * @throws StoreException
	 */
	void reset() throws StoreException;

	/**
	 * Create a data storage backup and returns the backup name
	 *
	 * @return the backup name
	 * @throws StoreException
	 */
	String createBackup() throws StoreException;

	/**
	 * List all available backup names
	 *
	 * @return
	 */
	List<String> getBackupList();

	/**
	 * Restore a data storage backup by its backup name
	 *
	 * @param backupName name of the backup
	 * @throws StoreException
	 */
	void restoreBackup(String backupName) throws StoreException;

	/**
	 * Returns the Data Access Object mappings for each Dto
	 *
	 * @return Data Access Object mappings for each Dto
	 */
	<T extends Dto> Map<Class<T>, Dao<T>> getDaoMappings();

	/**
	 * Retuns a Data Access Object which serves the class or null
	 *
	 * @param dtoType Dto type
	 * @return
	 */
	default <T extends Dto> Dao<T> getDao(final Class<T> dtoType) {
		return (Dao<T>) getDaoMappings().get(dtoType);
	}

	/**
	 * Clean unused items and optimize data storage
	 */
	void cleanAndOptimize();

	/**
	 * will be removed in version 2.1.0
	 */
	@Deprecated
	void addFile(final IFile file);
}
