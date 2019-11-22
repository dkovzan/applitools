package model;

import java.util.List;

public class DataSet {

    public DataSet(String label, String backgroundColor, String borderColor, Integer borderWidth, List<Integer> data) {
        this.label = label;
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
        this.borderWidth = borderWidth;
        this.data = data;
    }

    private String label;
    private String backgroundColor;
    private String borderColor;
    private Integer borderWidth;
    private List<Integer> data;

    @Override
    public String toString() {
        return "DataSet{" +
                "label='" + label + '\'' +
                ", backgroundColor='" + backgroundColor + '\'' +
                ", borderColor='" + borderColor + '\'' +
                ", borderWidth=" + borderWidth +
                ", data=" + data +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataSet dataSet = (DataSet) o;

        if (label != null ? !label.equals(dataSet.label) : dataSet.label != null) return false;
        if (backgroundColor != null ? !backgroundColor.equals(dataSet.backgroundColor) : dataSet.backgroundColor != null)
            return false;
        if (borderColor != null ? !borderColor.equals(dataSet.borderColor) : dataSet.borderColor != null) return false;
        if (borderWidth != null ? !borderWidth.equals(dataSet.borderWidth) : dataSet.borderWidth != null) return false;
        return data != null ? data.equals(dataSet.data) : dataSet.data == null;
    }

    @Override
    public int hashCode() {
        int result = label != null ? label.hashCode() : 0;
        result = 31 * result + (backgroundColor != null ? backgroundColor.hashCode() : 0);
        result = 31 * result + (borderColor != null ? borderColor.hashCode() : 0);
        result = 31 * result + (borderWidth != null ? borderWidth.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    public Integer getBorderWidth() {
        return borderWidth;
    }

    public void setBorderWidth(Integer borderWidth) {
        this.borderWidth = borderWidth;
    }

    public List<Integer> getData() {
        return data;
    }

    public void setData(List<Integer> data) {
        this.data = data;
    }
}
