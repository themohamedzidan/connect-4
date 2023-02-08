package mman131;
import javax.swing.JOptionPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
public class Controller2 {
	int[][] arrDesk = new int[5][7];
	int count = 0;
	int i1 = 4, i2 = 4, i3 = 4, i4 = 4, i5 = 4, i6 = 4, i7 = 4;
	@FXML
	private Button five;
	@FXML
	private Button one;
	@FXML
	private Button seven;
	@FXML
	private Button six;
	@FXML
	private Button three;
	@FXML
	private Button two;
	@FXML
	private GridPane root;
	//checks if the last desk put wins
	boolean checkWin(int[][] arrDesk, int rowPut, int colPut) {
		int player = arrDesk[rowPut][colPut];
		int count1 = 0;
		return (check1(arrDesk, rowPut, player, 0) || check2(arrDesk, colPut, player, 0)
				|| check3(arrDesk, rowPut, colPut, player) || check4(arrDesk, rowPut, colPut, player));
	}
	//check  Horizontal
	boolean check1(int[][] arrDesk, int rowPut, int player, int count1) {
		for (int i = 0; i < 7; i++) {
			if (arrDesk[rowPut][i] == player) {
				count1++;
				if (count1 >= 4)
					return true;
			} else
				count1 = 0;
		}
		return (count1 >= 4);
	}
	//check vertical
	boolean check2(int[][] arrDesk, int colPut, int player, int count1) {
		for (int i = 0; i < 5; i++)
			if (arrDesk[i][colPut] == player) {
				count1++;
				if (count1 >= 4)
					return true;
			} else
				count1 = 0;
		return (count1 >= 4);
	}
	//check diagonal left 
	boolean check3(int[][] arrdesk, int rowPut, int colPut, int player) {
		int sum = 0;
		int upRow, upCol, downRow, downCol;
		for (upRow = 0, upCol = 0; rowPut - upRow >= 0 && colPut - upCol >= 0; upRow++, upCol++) {
			if (arrdesk[rowPut - upRow][colPut - upCol] == player) {
				sum++;
				if (sum >= 4)
					return true;
			} else
				sum--;
		}
		for (downRow = 1, downCol = 1; downRow + rowPut < 5 && downCol + colPut < 7; downRow++, downCol++) {
			if (arrdesk[rowPut + downRow][colPut + downCol] == player) {
				sum++;
				if (sum >= 4)
					return true;
			} else
				sum--;
		}
		return (sum >= 4);
	}
	//check diagonal right
	boolean check4(int[][] arrdesk, int rowPut, int colPut, int player) {
		int sum = 0;
		int upRow, upCol, downRow, downCol;
		for (upRow = 0, downCol = 0; rowPut - upRow >= 0 && downCol + colPut < 7; upRow++, downCol++) {
			if (arrdesk[rowPut - upRow][downCol + colPut] == player) {
				sum++;
				if (sum >= 4)
					return true;
			} else
				sum--;
		}
		for (downRow = 1, upCol = 1; downRow + rowPut < 5 && colPut - upCol >= 0; downRow++, upCol++) {
			if (arrdesk[rowPut + downRow][colPut - upCol] == player) {
				sum++;
				if (sum >= 4)
					return true;
			} else
				sum--;
		}
		return (sum >= 4);
	}
	@FXML
	void clear(ActionEvent event) {
		root.getChildren().remove(8, count + 8);
		count = 0;
		i1 = 4;
		i2 = 4;
		i3 = 4;
		i4 = 4;
		i5 = 4;
		i6 = 4;
		i7 = 4;
		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 7; j++)
				arrDesk[i][j] = 0;
	}
	String value;
	@FXML
	void put(ActionEvent event) {
		value = (((Button) event.getSource()).getText());
		switch (value) {
		case ("1"): {
			if (i1 < 0) {
				JOptionPane.showMessageDialog(null, "NO", "Inane error", JOptionPane.ERROR_MESSAGE);
				break;
			} else {
				if (count % 2 == 0) {
					Circle c = new Circle(20, Color.RED);
					root.add(c, 0, i1);
					root.setHalignment(c, HPos.CENTER);
					arrDesk[i1][0] = 1;
					if (checkWin(arrDesk, i1, 0)) {
						Alert a = new Alert(AlertType.INFORMATION, "Red wins ");
						a.showAndWait();
					}
					i1--;
					count++;
					break;
				} else {
					Circle c = new Circle(20, Color.BLUE);
					root.add(c, 0, i1);
					root.setHalignment(c, HPos.CENTER);
					arrDesk[i1][0] = 2;
					if (checkWin(arrDesk, i1, 0)) {
						Alert a = new Alert(AlertType.INFORMATION, "Blue wins ");
						a.showAndWait();
					}
					i1--;
					count++;
					break;
				}
			}
		}
		case ("2"): {
			if (i2 < 0) {
				JOptionPane.showMessageDialog(null, "NO", "Inane error", JOptionPane.ERROR_MESSAGE);
				break;
			}
			{
				if (count % 2 == 0) {
					Circle c = new Circle(20, Color.RED);
					root.add(c, 1, i2);
					root.setHalignment(c, HPos.CENTER);
					arrDesk[i2][1] = 1;
					if (checkWin(arrDesk, i2, 1)) {
						Alert a = new Alert(AlertType.INFORMATION, "Red wins ");
						a.showAndWait();
					}
					i2--;
					count++;
					break;
				} else {
					Circle c = new Circle(20, Color.BLUE);
					root.add(c, 1, i2);
					root.setHalignment(c, HPos.CENTER);
					arrDesk[i2][1] = 2;
					if (checkWin(arrDesk, i2, 1)) {
						Alert a = new Alert(AlertType.INFORMATION, "Blue wins ");
						a.showAndWait();
					}
					i2--;
					count++;
					break;
				}
			}
		}
		case ("3"): {
			if (i3 < 0) {
				JOptionPane.showMessageDialog(null, "NO", "Inane error", JOptionPane.ERROR_MESSAGE);
				break;
			} else {
				if (count % 2 == 0) {
					Circle c = new Circle(20, Color.RED);
					root.add(c, 2, i3);
					root.setHalignment(c, HPos.CENTER);
					arrDesk	[i3][2] = 1;
					if (checkWin(arrDesk, i3, 2)) {
						Alert a = new Alert(AlertType.INFORMATION, "Red wins ");
						a.showAndWait();
					}
					i3--;
					count++;
					break;
				} else {
					Circle c = new Circle(20, Color.BLUE);
					root.add(c, 2, i3);
					root.setHalignment(c, HPos.CENTER);
					arrDesk[i3][2] = 2;
					if (checkWin(arrDesk, i3, 2)) {
						Alert a = new Alert(AlertType.INFORMATION, "Blue wins ");
						a.showAndWait();
					}
					i3--;
					count++;
					break;
				}
			}
		}
		case ("4"): {
			if (i4 < 0) {
				JOptionPane.showMessageDialog(null, "NO", "Inane error", JOptionPane.ERROR_MESSAGE);
				break;
			} else {
				if (count % 2 == 0) {
					Circle c = new Circle(20, Color.RED);
					root.add(c, 3, i4);
					root.setHalignment(c, HPos.CENTER);
					arrDesk[i4][3] = 1;
					if (checkWin(arrDesk, i4, 3)) {
						Alert a = new Alert(AlertType.INFORMATION, "Red wins ");
						a.showAndWait();
					}
					i4--;
					count++;
					break;
				} else {
					Circle c = new Circle(20, Color.BLUE);
					root.add(c, 3, i4);
					root.setHalignment(c, HPos.CENTER);
					arrDesk[i4][3] = 2;
					if (checkWin(arrDesk, i4, 3)) {
						Alert a = new Alert(AlertType.INFORMATION, "Blue wins ");
						a.showAndWait();
					}
					i4--;
					count++;
					break;
				}
			}
		}
		case ("5"): {
			if (i5 < 0) {
				JOptionPane.showMessageDialog(null, "NO", "Inane error", JOptionPane.ERROR_MESSAGE);
				break;
			} else {
				if (count % 2 == 0) {
					Circle c = new Circle(20, Color.RED);
					root.add(c, 4, i5);
					root.setHalignment(c, HPos.CENTER);
					arrDesk[i5][4] = 1;
					if (checkWin(arrDesk, i5, 4)) {
						Alert a = new Alert(AlertType.INFORMATION, "Red wins ");
						a.showAndWait();
					}
					i5--;
					count++;
					break;
				} else {
					Circle c = new Circle(20, Color.BLUE);
					root.add(c, 4, i5);
					root.setHalignment(c, HPos.CENTER);
					arrDesk[i5][4] = 2;
					if (checkWin(arrDesk, i5, 4)) {
						Alert a = new Alert(AlertType.INFORMATION, "Blue wins ");
						a.showAndWait();
					}
					i5--;
					count++;
					break;
				}
			}
		}
		case ("6"): {
			if (i6 < 0) {
				JOptionPane.showMessageDialog(null, "NO", "Inane error", JOptionPane.ERROR_MESSAGE);
				break;
			} else {
				if (count % 2 == 0) {
					Circle c = new Circle(20, Color.RED);
					root.add(c, 5, i6);
					root.setHalignment(c, HPos.CENTER);
					arrDesk[i6][5] = 1;
					if (checkWin(arrDesk, i6, 5)) {
						Alert a = new Alert(AlertType.INFORMATION, "Red wins ");
						a.showAndWait();
					}
					i6--;
					count++;
					break;
				} else {
					Circle c = new Circle(20, Color.BLUE);
					root.add(c, 5, i6);
					root.setHalignment(c, HPos.CENTER);
					arrDesk[i6][5] = 2;
					if (checkWin(arrDesk, i6, 5)) {
						Alert a = new Alert(AlertType.INFORMATION, "Blue wins ");
						a.showAndWait();
					}
					i6--;
					count++;
					break;
				}
			}
		}
		case ("7"): {
			if (i7 < 0) {
				JOptionPane.showMessageDialog(null, "NO", "Inane error", JOptionPane.ERROR_MESSAGE);
				break;
			} else {
				if (count % 2 == 0) {
					Circle c = new Circle(20, Color.RED);
					root.add(c, 6, i7);
					root.setHalignment(c, HPos.CENTER);
					arrDesk[i7][6] = 1;
					if (checkWin(arrDesk, i7, 6)) {
						Alert a = new Alert(AlertType.INFORMATION, "Red wins ");
						a.showAndWait();
					}
					i7--;
					count++;
					break;
				} else {
					Circle c = new Circle(20, Color.BLUE);
					root.add(c, 6, i7);
					root.setHalignment(c, HPos.CENTER);
					arrDesk[i7][6] = 2;
					if (checkWin(arrDesk, i7, 6)) {
						Alert a = new Alert(AlertType.INFORMATION, "Blue wins ");
						a.showAndWait();
					}
					i7--;
					count++;
					break;
				}
			}
		}
		}
	}
}
