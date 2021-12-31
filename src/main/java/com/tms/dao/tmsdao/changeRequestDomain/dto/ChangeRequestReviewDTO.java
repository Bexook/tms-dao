package com.tms.dao.tmsdao.changeRequestDomain.dto;

import com.tms.dao.tmsdao.changeRequestDomain.entity.ChangeRequestCommentEntity;
import com.tms.dao.tmsdao.changeRequestDomain.entity.ChangeRequestEntity;
import com.tms.dao.tmsdao.changeRequestDomain.enumTypes.ChangeRequestState;
import lombok.Data;

import java.util.List;

@Data
public class ChangeRequestReviewDTO {

    private Long approverId;
    private Long createdBy;
    private Long modifiedBy;
    private ChangeRequestEntity changeRequestEntity;
    private List<ChangeRequestCommentEntity> comment;
    private ChangeRequestState currentState;

}
