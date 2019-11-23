package Data;

import java.util.ArrayList;

import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;

import Utils.DataHelper;
import Utils.PriceHelper;

public class RefinedData {

	private String[] spinnername = { "chessespinner", "quarterspinner", "chickenspinner", "filletspinner",
			"samosaspinner", "pakoraspinner", "mixedspinner", "onionspinner" };
	private SpinnerListModel model = new SpinnerListModel(spinnername);
	private JSpinner[] jspinnername;
	private ArrayList<PriceHelper> pricehelper;
	private ArrayList<String> clickData;
	private ArrayList<DataHelper> datahelper;
	private int count = -1;

	public RefinedData(ArrayList<PriceHelper> helper, ArrayList<String> clickedData, JSpinner[] jspinnername) {
		pricehelper = helper;
		clickData = clickedData;
		this.jspinnername = jspinnername;
		datahelper = new ArrayList<DataHelper>();
	}

	public ArrayList<DataHelper> manuplateData() {

		for (PriceHelper datafetch : pricehelper) {

			if (clickData.contains(datafetch.getItemName())) {
				for (String string : spinnername) {
					count++;
					if (datafetch.getItemName().substring(0, 3).toLowerCase().equals(string.substring(0, 3))) {
						datahelper.add(new DataHelper(datafetch.getItemName(), datafetch.getPrice(),
								(int) jspinnername[count].getValue(),
								(datafetch.getPrice() * (int) jspinnername[count].getValue())));
					} else {
						count--;
					}
				}
			} else {
				count++;
			}
		}
		return datahelper;
	}

}
