package com.tms.dao.tmsdao.changeRequestDomain.entityMarker;

import java.io.Serializable;

public interface ChangeRequestEntityMarker extends Serializable {
    <T extends Number> T getId();
}
