package com.git.models.requests;



import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;



public class GetSingleRepoPOJO {


private String name;
private String fullName;
private Boolean _private;
private String defaultBranch;

private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();



public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getFullName() {
return fullName;
}

public void setFullName(String fullName) {
this.fullName = fullName;
}

public Boolean getPrivate() {
return _private;
}

public void setPrivate(Boolean _private) {
this._private = _private;
}

public String getDefaultBranch() {
return defaultBranch;
}

public void setDefaultBranch(String defaultBranch) {
this.defaultBranch = defaultBranch;
}




@Override
public boolean equals(Object other) {
if (other == this) {
return true;
}
if ((other instanceof GetSingleRepoPOJO) == false) {
return false;
}
GetSingleRepoPOJO rhs = ((GetSingleRepoPOJO) other);
return ((this.fullName == rhs.fullName)||((this.fullName!= null)&&this.fullName.equals(rhs.fullName)));
}



}