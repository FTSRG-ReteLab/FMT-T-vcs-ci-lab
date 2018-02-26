package hu.bme.mit.train.sensor;

import com.google.common.collect.ArrayTable;
import com.google.common.collect.Table;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;
public class Tachograph {

	private TrainController controller;
	private TrainUser user;
	private Table table;

	public Tachograph(TrainController controller, TrainUser user) {
		this.controller = controller;
		this.user = user;
		this.table = ArrayTable.create(null);
	}


}
