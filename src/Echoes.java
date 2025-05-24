/*
 * A class that has the base information of Echoes.
 */
public class Echoes {
	
	//List of possible substats of the Echo
	protected String[] substats = {"HP", "ATK", "DEF", "HP%", "ATK%", "DEF%", "Energy Recharge", "CRIT RATE", "CRIT DMG", "Basic Attack DMG Bonus", "Heavy Attack DMG Bonus", "Resounance Skill DMG Bonus", "Resounance Liberation DMG Bonus"};
	//List of possible values for each substat
	private double[] HPValues = {320, 360, 390, 430, 470, 510, 540, 580};
	private double[] AtkValues = {30, 40, 50, 60};
	private double[] DefValues = {40, 50, 60, 70};
	private double[] HpPercentValues = {6.4, 6.4, 7.9, 8.6, 9.4, 10.1, 10.9, 11.6};
	private double[] AtkPercentValues = {6.4, 7.1, 7.9, 8.6, 9.4, 10.1, 10.9, 11.6};
	private double[] DefPercentValues = {8.1, 9.0, 10.0, 10.9, 11.8, 12.8, 13.8, 14.7};
	private double[] ERValues = {6.8, 7.6, 8.4, 9.2, 10.0, 10.8, 11.6, 12.4};
	private double[] CRValues = {6.3, 6.9, 7.5, 8.1, 8.7, 9.3, 9.9, 10.5};
	private double[] CDValues = {12.6, 13.8, 15.0, 16.2, 17.4, 18.6, 19.8, 21.0};
	private double[] BasicHeavySkillLiberationDmgValues = {6.4, 7.1, 7.9, 8.6, 9.4, 10.1, 10.9, 11.6};
	
	/**
	 * A function to return a random substat from the list of possible substats
	 * @return			a random substat name.
	 */
	public String getRandomSubstatName() {
		//Generate a random number between 0 and 12, both inclusive
		int index = (int)(Math.random() * 13);
		
		return this.substats[index];
	}
	
	/**
	 * A function that returns a random value for a specific substat.
	 * Note: Can also be used to upgrade a substat!
	 * 
	 * @param name			the name of the substat
	 * @return				value of the substat
	 */
	public double getSubstatValue(String name) {
		//Get a random index number between 0 and 7, both inclusive.
		int index = (int)(Math.random() * 8);
		
		//Check the name of the substat and return the appropriate value
		if(name.compareTo("HP") == 0) {
			return this.HPValues[index];
		} else if(name.compareTo("ATK") == 0) {
			return this.AtkValues[index / 2];
		} else if(name.compareTo("DEF") == 0) {
			return this.DefValues[index / 2];
		} else if(name.compareTo("HP%") == 0) {
			return this.HpPercentValues[index];
		} else if(name.compareTo("ATK%") == 0) {
			return this.AtkPercentValues[index];
		} else if(name.compareTo("DEF%") == 0) {
			return this.DefPercentValues[index];
		} else if(name.compareTo("Energy Recharge") == 0) {
			return this.ERValues[index];
		} else if(name.compareTo("CRIT RATE") == 0) {
			return this.CRValues[index];
		} else if(name.compareTo("CRIT DMG") == 0) {
			return this.CDValues[index];
		}
		
		//If the name matches none of the above options, it has to be Basic, Heavy, Skill or Liberation Dmg Bonus, so return value from BasicHeavySkillLiberationDmgValues list.
		return this.BasicHeavySkillLiberationDmgValues[index];
	}
}
