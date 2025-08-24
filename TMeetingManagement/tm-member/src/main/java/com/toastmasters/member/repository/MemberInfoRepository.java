package com.toastmasters.member.repository;

import com.toastmasters.member.entity.MemberInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 会员信息仓储接口
 * </p>
 *
 * @author seekpan
 */
@Repository
public interface MemberInfoRepository extends JpaRepository<MemberInfo, String> {

}
