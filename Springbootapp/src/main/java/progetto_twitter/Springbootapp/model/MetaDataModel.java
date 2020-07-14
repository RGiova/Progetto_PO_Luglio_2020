package progetto_twitter.Springbootapp.model;

/** 
 *@author Recchi Giovanni, Sopranzetti Lorenzo, Francesco Pigliapoco
 */

/** 
 * Modello che raccoglie le informazioni sui metadata
 */

public class MetaDataModel {
private String alias;
private String sourceField;
private String type;

public String getAlias() {
	return alias;
}
public void setAlias(String alias) {
	this.alias = alias;
}
public String getSourceField() {
	return sourceField;
}
public void setSourceField(String sourceField) {
	this.sourceField = sourceField;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}

}
