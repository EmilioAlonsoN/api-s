package nl.h2.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * This function is the Entity for the database
 */

@Entity
public class Users {

    private String source;
    private String codeListCode;

    @Id
    @Column(unique = true)
    private String code;

    private String displayValue;
    private String longDescription;
    private String fromDate;
    private String toDate;
    private String sortingPriority;

    public Users() {}

    public Users(String source, String codeListCode, String code, String displayValue, String longDescription,
                 String fromDate, String toDate, String sortingPriority) {

        this.source = source;
        this.codeListCode = codeListCode;
        this.code = code;
        this.displayValue = displayValue;
        this.longDescription = longDescription;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.sortingPriority = sortingPriority;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCodeListCode() {
        return codeListCode;
    }

    public void setCodeListCode(String codeListCode) {
        this.codeListCode = codeListCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    public void setDisplayValue(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getSortingPriority() {
        return sortingPriority;
    }

    public void setSortingPriority(String sortingPriority) {
        this.sortingPriority = sortingPriority;
    }

    public String toString() {

        return String.format("Users [source=%s; codeListCode=%s; code=%s; displayValue=%s; " +
                             "longDescription=%s; fromDate=%s; toDate=%s; sortingPriority=%s]",
                source,
                codeListCode,
                code,
                displayValue,
                longDescription,
                fromDate,
                toDate,
                sortingPriority);
    }
}
