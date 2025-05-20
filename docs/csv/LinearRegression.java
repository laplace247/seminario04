package cn.rocket.ml;



import java.io.IOException;

import java.util.ArrayList;

import java.util.List;



import cn.rocket.data.DataSet;

import cn.rocket.utils.ScatterPlot;



public class LinearRegression {



private double theta0 = 0.0 ; //interceptar

private double theta1 = 0.0 ; //Pendiente

private double alpha = 0.01 ; //Tasa de aprendizaje



private int max_itea = 20000 ; // Número máximo de pasos de iteración



private DataSet dataSet = new DataSet() ;



public LinearRegression() throws IOException{

dataSet.loadDataFromTxt("datas/house_price.txt", ",",1);

}



public double predict(double x){

return theta0+theta1*x ;

}



public double calc_error(double x, double y) {

return predict(x)-y;

}



public void gradientDescient(){

double sum0 =0.0 ;

double sum1 =0.0 ;



for(int i = 0 ; i < dataSet.getSize() ;i++) {

sum0 += calc_error(dataSet.getDatas().get(i).get(0), dataSet.getLabels().get(i)) ;

sum1 += calc_error(dataSet.getDatas().get(i).get(0), dataSet.getLabels().get(i))*dataSet.getDatas().get(i).get(0) ;

}



this.theta0 = theta0 - alpha*sum0/dataSet.getSize() ;

this.theta1 = theta1 - alpha*sum1/dataSet.getSize() ;



}



public void lineGre() {

int itea = 0 ;

while( itea< max_itea){

//System.out.println(error_rate);

System.out.println("The current step is :"+itea);

System.out.println("theta0 "+theta0);

System.out.println("theta1 "+theta1);

System.out.println();

gradientDescient();

itea ++ ;

}

} ;



public static void main(String[] args) throws IOException {

LinearRegression linearRegression = new LinearRegression() ;

linearRegression.lineGre();

List<Double> list = new ArrayList<Double>() ;



for(int i = 0 ; i < linearRegression.dataSet.getSize() ;i++) {

list.add(linearRegression.dataSet.getDatas().get(i).get(0));

}



ScatterPlot.data("Datas", list, linearRegression.dataSet.getLabels(),linearRegression.theta0,linearRegression.theta1);



}



}