/*
 * A class to simulate the 3-Cost Echo piece.
 */
public class ThreeCostPiece extends Echoes {
	
	private String echoName;
	private String MainStatName;
	private double[] MainStatValues;
	private String SecondStatName = "ATK";
	private int[] SecondStatValues = {20, 36, 52, 68, 84, 100};
	private int numberOfLevelUps;
	private int totalTuneSlots;
	private int tuneIndex;
	private String[] substatNames;
	private double[] substatValues;
	private int numberOfSubstats = 5;
	
	//Possible main stat names and values.
	private String[] mainStatNamesList = {"HP%", "ATK%", "DEF%", "Glacio DMG Bonus", "Fusion DMG Bonus", "Electro DMG Bonus", "Aero DMG Bonus", "Spectro DMG Bonus", "Havoc DMG Bonus", "Energy Regen"};
	private double[] DefPercentMainStat = {7.6, 13.6, 19.7, 25.8, 31.9, 38.0};
	private double[] HpAtkElementalPercentMainStat = {6.0, 10.8, 15.6, 20.4, 25.2, 30.0};
	private double[] EnergyPercentMainStat = {6.4, 11.5, 16.6, 21.7, 26.8, 32.0};
	
	/**
	 * Constructor for the ThreeCostPiece class
	 */
	public ThreeCostPiece() {
		//Initialise values
		this.echoName = "3-Cost";
		this.numberOfLevelUps = 0;
		this.totalTuneSlots = 0;
		this.tuneIndex = 0;
		this.substatNames = new String[this.numberOfSubstats];
		this.substatValues = new double[this.numberOfSubstats];
		
		//Gets a random index and then grabs the main stat name.
		int mainStatIndex = (int)(Math.random() * 10);
		this.MainStatName = this.mainStatNamesList[mainStatIndex];
		//Depending on the main stat name, set the correct values.
		if(mainStatIndex == 2) {
			this.MainStatValues = this.DefPercentMainStat;
		} else if(mainStatIndex == 9){
			this.MainStatValues = this.EnergyPercentMainStat;
		} else {
			this.MainStatValues = this.HpAtkElementalPercentMainStat;
		}
		
		//Sets the 5 substats to "upgrade to +X to get substat", where X is value of level at multiples of 5.
		for(int i = 0; i < this.substatNames.length; i++) {
			this.substatNames[i] = "Upgrade this echo to +" + ((i + 1) * 5) + " to tune this substat";
			this.substatValues[i] = 0.0;
		}
	}
	
	/**
	 * A function that will level the three cost piece by +5 ranks.
	 */
	public void levelThreeCostPiece() {
		//increment level up counter by 1
		this.numberOfLevelUps++;
		
		if(this.numberOfLevelUps <= this.numberOfSubstats) {
			//Set the new substat value to be "To be tuned"
			this.substatNames[this.numberOfLevelUps - 1] = "To be tuned";
			this.totalTuneSlots++;
		} else {
			//If the number of level ups is past the maximum, then lower it to avoid error, then return to stop the upgrade.
			this.numberOfLevelUps--;
			return;
		}
	}
	
	/**
	 * A function that will tune a substat of the echo
	 */
	public void tuneThreeCostPiece() {
		boolean insertionDone = false; //Checks to see if the substat has been inserted.
		//Loops until the substat has been inserted
		while(!insertionDone) {
			//Only runs if the total tuneable slots is larger than 0
			if(this.totalTuneSlots > 0) {
				String name = getRandomSubstatName(); //Name of the substat
				//If the tuneable slot is the first slot, i.e. the tuneable substat is the first ever for this echo.
				if(this.tuneIndex == 0) {
					this.substatNames[this.tuneIndex] = name;
					this.substatValues[this.tuneIndex] = getSubstatValue(this.substatNames[this.tuneIndex]);
					insertionDone = true; //End the loop
					//Decrease the total tuneable slots.
					this.totalTuneSlots = this.totalTuneSlots - 1;
					//Increment the tuneable index.
					this.tuneIndex++;
				//otherwise the tuneable substat is not the first ever, and need to check for duplicates.
				} else {
					boolean alreadyPresent = false;
					//Loop through the list of sub stats to check for duplicates.
					for(int i = 0; i < this.substatNames.length; i++) {
						if(this.substatNames[i].compareTo(name) == 0) {
							alreadyPresent = true;
							break;
						}
					}
					
					//If the substats is not in the list already, add it to the list and add the value to this list
					if(!alreadyPresent) {
						//Add the substat to the array, get the value of the substat and add that to the array too.
						this.substatNames[this.tuneIndex] = name;
						this.substatValues[this.tuneIndex] = getSubstatValue(this.substatNames[this.tuneIndex]);
						insertionDone = true;
						//Decrease the total tuneable slots.
						this.totalTuneSlots = this.totalTuneSlots - 1;
						//Increment the tuneable index.
						this.tuneIndex++;
					}
				}
			//Otherwise the total tuneable slots is not larger than 0, so echo is not tuneable.
			} else {
				return;
			}
		}
	}
	
	/**
	 * A function that returns the name of the artifact: 3-Cost.
	 * @return			name of the artifact: 3-Cost
	 */
	public String getEchoName() {
		return this.echoName;
	}
	
	/**
	 * A funtion that returns the name of the main stat
	 * @return			main stat name
	 */
	public String getMainStatName() {
		return this.MainStatName;
	}
	
	/**
	 * A funtion that returns the value of the main stat
	 * @return			main stat value
	 */
	public double getMainStatValue() {
		return this.MainStatValues[this.numberOfLevelUps];
	}
	
	/**
	 * A funtion that returns the name of the secondary stat
	 * @return			secondary stat name
	 */
	public String getSecondStatName() {
		return this.SecondStatName;
	}
	
	/**
	 * A funtion that returns the value of the secondary stat
	 * @return			secondary stat value
	 */
	public double getSecondStatValue() {
		return this.SecondStatValues[this.numberOfLevelUps];
	}
	
	/**
	 * A function that returns the current level of the 3-Cost piece
	 * @return			current 3-Cost piece level
	 */
	public int getCurrentLevel() {
		return this.numberOfLevelUps * 5;
	}
	
	/**
	 * A functiont that returns the list of substat names
	 * @return			list of substat names
	 */
	public String[] getSubstatNames() {
		return this.substatNames;
	}
	
	/**
	 * A function that returns the list of substat values
	 * @return			list of substat values
	 */
	public double[] getSubstatValues() {
		return this.substatValues;
	}
	
	/**
	 * A function that prints out all the stats of the 3-Cost piece
	 */
	public void printInfo() {
		System.out.print(getMainStatName() + ": ");
		System.out.println(getMainStatValue());
		
		System.out.print(getSecondStatName() + ": ");
		System.out.println(getSecondStatValue());
		
		for(int i = 0; i < this.numberOfSubstats; i++) {
			System.out.print(this.substatNames[i] + ": " + this.substatValues[i] + "\n");
		}
	}
}
