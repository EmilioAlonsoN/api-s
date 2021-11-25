package nl.h2.api.api;


import nl.h2.api.model.Users;

public class CodeDTO {

    private final String source;
    private final String codeListCode;
    private final String code;
    private final String displayValue;
    private final String longDescription;
    private final String fromDate;
    private final String toDate;
    private final String sortingPriority;


    public CodeDTO(String source, String codeListCode, String code, String displayValue,
                   String longDescription, String fromDate, String toDate, String sortingPriority) {

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

    public String getCodeListCode() {
        return codeListCode;
    }

    public String getCode() {
        return code;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public String getFromDate() {
        return fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public String getSortingPriority() {
        return sortingPriority;
    }

    public static CodeDTO toUsersDTO(Users users) {

        return new CodeDTO(
                users.getSource(),
                users.getCodeListCode(),
                users.getCode(),
                users.getDisplayValue(),
                users.getLongDescription(),
                users.getFromDate(),
                users.getToDate(),
                users.getSortingPriority());
    }
}

