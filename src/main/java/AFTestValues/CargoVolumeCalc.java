package AFTestValues;

import java.util.Locale;

public class CargoVolumeCalc {
    private int Length;                                         //(100);
    private int Width;                                          //(20);
    private int Height;                                         //(200);
    private double volume;

    public CargoVolumeCalc(int length, int width, int height){
        this.Length = length;
        this.Width = width;
        this.Height = height;
    }

    public void calculateVolume(){
        this.volume = (this.Length * this.Width * this.Height) / 1000000.0; //конвертируем сантиметры в кубические метры
    }

    public String getPackageVolume(){                              //делаем строку результата как на странице результата
        calculateVolume();
        return String.format(Locale.US,"%.3f", this.volume);
    }
}
