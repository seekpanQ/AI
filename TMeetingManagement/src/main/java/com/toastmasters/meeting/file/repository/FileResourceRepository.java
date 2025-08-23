package com.toastmasters.meeting.file.repository;

import com.toastmasters.meeting.file.entity.FileResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *   文件资源仓库接口
 * </p>
 * @author seekpan
 */
@Repository
public interface FileResourceRepository extends JpaRepository<FileResource, Long> {
}