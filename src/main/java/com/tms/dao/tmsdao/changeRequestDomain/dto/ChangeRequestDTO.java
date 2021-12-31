package com.tms.dao.tmsdao.changeRequestDomain.dto;


import com.tms.dao.tmsdao.changeRequestDomain.entity.ChangeRequestCommentEntity;
import com.tms.dao.tmsdao.changeRequestDomain.enumTypes.ChangeRequestState;
import com.tms.dao.tmsdao.changeRequestDomain.enumTypes.OperationType;
import com.tms.dao.tmsdao.domain.enumTypes.auth.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChangeRequestDTO {
    private Long id;
    private String createdBy;
    private String modifiedBy;
    private UserRole userRole;
    private ChangeRequestState changeRequestState;
    private OperationType operationType;
    private String currentObjectState;
    private String newObjectState;
    private String domainClass;
    private Set<ChangeRequestCommentEntity> changeRequestCommentEntities;
    private boolean relevant = true;
    private String objectRepo;
}
