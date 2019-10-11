package AFTestValues;

public class CargoDimensions {

    private int Length;                                         //(100);
    public int getLength(){   return this.Length;   }
    public void setLength(int length){   this.Length = length;   }

    private int Width;                                          //(20);
    public int getWidth(){   return this.Width;   }
    public void setWidth(int width){   this.Width = width;   }

    private int Height;                                         //(200);
    public int getHeight(){   return this.Height;    }
    public void setHeight(int height){   this.Height = height;   }

    private int Weight;                                         //(200);
    public int getWeight(){   return this.Weight;   }

    public String getWeightAsString(){
        return String.valueOf(this.Weight);
    }
    public void setWeight(int weight){   this.Weight = weight;   }

}
