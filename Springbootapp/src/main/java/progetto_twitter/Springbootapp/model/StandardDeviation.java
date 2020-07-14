package progetto_twitter.Springbootapp.model;

/** 
 *@author Recchi Giovanni, Sopranzetti Lorenzo, Francesco Pigliapoco
 */

/**
 * Calcolo cumulatuivo della deviazione standard
 */
public class StandardDeviation {
    int n = 0;
    double sum = 0;
    double sum2 = 0;
 
    public double SD(double x) {
	n++;
	sum += x;
	sum2 += x*x;
 
	return Math.sqrt(sum2/n - sum*sum/n/n);
    }
}