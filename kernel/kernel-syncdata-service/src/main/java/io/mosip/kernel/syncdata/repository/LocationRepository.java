package io.mosip.kernel.syncdata.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.mosip.kernel.core.dataaccess.spi.repository.BaseRepository;
import io.mosip.kernel.syncdata.entity.Location;

/**
 * This interface is JPA repository class which interacts with database and does
 * the CRUD function. It is extended from {@link BaseRepository}
 * 
 * @author Srinivasan
 *
 */
@Repository
public interface LocationRepository extends BaseRepository<Location, String> {

	/**
	 * Method to find list of Location created , updated or deleted time is greater
	 * than lastUpdated timeStamp.
	 * 
	 * @param lastUpdated
	 *            timeStamp - last updated time
	 * @param currentTimeStamp
	 *            - currentTimestamp
	 * @return list of {@link Location} - list of location
	 */
	@Query("FROM Location WHERE (createdDateTime > ?1 AND createdDateTime <= ?2) OR (updatedDateTime > ?1 AND updatedDateTime <= ?2)  OR (deletedDateTime >?1 AND deletedDateTime <= ?2)")
	List<Location> findAllLatestCreatedUpdateDeleted(LocalDateTime lastUpdated, LocalDateTime currentTimeStamp);

}
