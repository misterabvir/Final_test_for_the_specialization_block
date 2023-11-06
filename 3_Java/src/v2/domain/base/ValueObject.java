package v2.domain.base;

import java.util.List;

public abstract class ValueObject{
    protected abstract List<Object> getFields();
    private boolean compareFields(List<Object> l1, List<Object> l2){
        if(l1.size() != l2.size()){
            return false;
        }
        for (int i = 0; i < l1.size(); i++) {
            if(!l1.get(i).equals(l2.get(i))){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof ValueObject valueObject &&  compareFields(getFields(), valueObject.getFields());
    }

    @Override
    public int hashCode() {
        return getFields().hashCode();
    }
}
