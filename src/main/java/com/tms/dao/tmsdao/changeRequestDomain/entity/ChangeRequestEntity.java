package com.tms.dao.tmsdao.changeRequestDomain.entity;


import com.tms.dao.tmsdao.changeRequestDomain.enumTypes.ChangeRequestState;
import com.tms.dao.tmsdao.changeRequestDomain.enumTypes.OperationType;
import com.tms.dao.tmsdao.domain.BaseEntity;
import com.tms.dao.tmsdao.domain.enumTypes.auth.UserRole;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Table;
import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "change_request")
@EqualsAndHashCode(callSuper = true)
@Where(clause = " is_relevant = true ")
@SQLDelete(sql = "UPDATE change_request SET is_relevant = 0 WHERE public.change_request.id= ? ", check = ResultCheckStyle.COUNT)
public class ChangeRequestEntity extends BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Enumerated(EnumType.STRING)
    @Column(name = "approver_role")
    private UserRole userRole;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "state")
    private ChangeRequestState changeRequestState;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "operation_type")
    private OperationType operationType;
    @Column(name = "current_object_state")
    private String currentObjectState;

    @Column(name = "new_object_state")
    private String newObjectState;

    @Column(name = "domain_class")
    private String domainClass;

    @OneToMany(
            targetEntity = ChangeRequestCommentEntity.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinTable(name = "change_request_comments_ref",
            joinColumns = {
                    @JoinColumn(
                            name = "change_request_id",
                            referencedColumnName = "id",
                            table = "change_request",
                            foreignKey = @ForeignKey(name = "change_request_id_fk")
                    )},
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "comment_id",
                            referencedColumnName = "id",
                            table = "change_request_comment",
                            foreignKey = @ForeignKey(name = "comment_id_fk")
                    )}
    )
    @Fetch(FetchMode.JOIN)
    private Set<ChangeRequestCommentEntity> changeRequestCommentEntities;

    @Column(name = "is_relevant")
    private boolean relevant = true;

    @Column(name = "object_repo")
    private String objectRepo;


}
