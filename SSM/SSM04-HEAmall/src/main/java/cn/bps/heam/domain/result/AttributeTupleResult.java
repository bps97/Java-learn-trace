package cn.bps.heam.domain.result;

import java.util.List;

public class AttributeTupleResult {

    List<AttributeResult> immutable;

    List<AttributeResult> dynamic;

    public List<AttributeResult> getImmutable() {
        return immutable;
    }

    public void setImmutable(List<AttributeResult> immutable) {
        this.immutable = immutable;
    }

    public List<AttributeResult> getDynamic() {
        return dynamic;
    }

    public void setDynamic(List<AttributeResult> dynamic) {
        this.dynamic = dynamic;
    }
}
