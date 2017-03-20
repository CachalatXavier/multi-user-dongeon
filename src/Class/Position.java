package Class;

import java.io.Serializable;

// La position est composée de coordonnées x et y permettant de situer la picèe dans le donjon
public class Position implements Serializable {
		private int x ;
		private int y ;
		
		public Position ( int x , int y){
			this.x = x; 
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}
		
}
