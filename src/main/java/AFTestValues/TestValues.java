package AFTestValues;

public class TestValues {
    //Отличие от CargoDimensions в том, что в этом классе хочу собрать вообще все тестируемые данные

    private int length;                                         //(100);
    public int getLength(){   return this.length;   }
    public void setLength(int length){   this.length = length;   }

    private int width;                                          //(20);
    public int getWidth(){   return this.width;   }
    public void setWidth(int width){   this.width = width;   }

    private int height;                                         //(200);
    public int getHeight(){   return this.height;   }
    public void setHeight(int height){   this.height = height;   }

    private int weight;                                         //(200);
    public int getWeight(){   return this.weight;   }
    public void setWeight(int weight){   this.weight = weight;   }

    private String departureOptionsCity;                                         //(200);
    public String getDepartureOptionsCity(){   return this.departureOptionsCity;   }
    public void setDepartureOptionsCity(String str){   this.departureOptionsCity = str;   }

    private String arrivalDropDownLetter;                                         //(200);
    public String getArrivalDropDownLetter(){   return this.arrivalDropDownLetter;   }
    public void setArrivalDropDownLetter(String str){   this.arrivalDropDownLetter = str;   }

    private String arrivalDropDownCity;                                         //(200);
    public String getArrivalDropDownCity(){   return this.arrivalDropDownCity;   }
    public void setArrivalDropDownCity(String str){   this.arrivalDropDownCity = str;   }
}
