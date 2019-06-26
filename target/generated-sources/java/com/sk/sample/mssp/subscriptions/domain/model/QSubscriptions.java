package com.sk.sample.mssp.subscriptions.domain.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSubscriptions is a Querydsl query type for Subscriptions
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSubscriptions extends EntityPathBase<Subscriptions> {

    private static final long serialVersionUID = 1492634831L;

    public static final QSubscriptions subscriptions = new QSubscriptions("subscriptions");

    public final com.sk.sample.mssp.shared.base.QAbstractEntity _super = new com.sk.sample.mssp.shared.base.QAbstractEntity(this);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath ottId = createString("ottId");

    public final NumberPath<Long> partyId = createNumber("partyId", Long.class);

    public final StringPath subscriptionsName = createString("subscriptionsName");

    public QSubscriptions(String variable) {
        super(Subscriptions.class, forVariable(variable));
    }

    public QSubscriptions(Path<? extends Subscriptions> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSubscriptions(PathMetadata metadata) {
        super(Subscriptions.class, metadata);
    }

}

