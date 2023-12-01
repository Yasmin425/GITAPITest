package com.git.models.response;

import java.util.LinkedHashMap;
import java.util.Map;



public class UpdateRepoPOJO {

private String name;
private String description;
private String _private;
private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getDescription() {
return description;
}

public void setDescription(String description) {
this.description = description;
}

public String getPrivate() {
return _private;
}

public void setPrivate(String _private) {
this._private = _private;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

@Override
public int hashCode() {
int result = 1;
result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
result = ((result* 31)+((this.description == null)? 0 :this.description.hashCode()));
result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
result = ((result* 31)+((this._private == null)? 0 :this._private.hashCode()));
return result;
}

@Override
public boolean equals(Object other) {
if (other == this) {
return true;
}
if ((other instanceof UpdateRepoPOJO) == false) {
return false;
}
UpdateRepoPOJO rhs = ((UpdateRepoPOJO) other);
return (((((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name)))&&((this.description == rhs.description)||((this.description!= null)&&this.description.equals(rhs.description))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this._private == rhs._private)||((this._private!= null)&&this._private.equals(rhs._private))));
}

}
