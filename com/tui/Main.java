package com.tui;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import javax.swing.*;
/*
public class Main extends JFrame{
	// private Main Main = new Main("hello world");
	public Main(){
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JRootPane root = getRootPane();


		CustomDrawingPanel panel = new CustomDrawingPanel();

		add(panel);
		new Thread(panel).start();

		root.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
			.put(KeyStroke.getKeyStroke("SPACE"), "increaseTime");
			

		root.getActionMap()
			.put("increaseTime", new AbstractAction() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("ok");
					panel.point.x += 2;
				}
			});
		setVisible(true);
	}
	public static void Main(String[] args) {
		SwingUtilities.invokeLater(Main::new);
	}
}

class CustomDrawingPanel extends JPanel implements Runnable {

	public int time = 0;

	public Point point = new Point(0,0);
	public Point point2 = new Point(20,0);

	@Override 
	public void run(){
		while(this != null){
			time++;
			repaint();
			try {
				Thread.sleep(100);	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

    public CustomDrawingPanel() {
        // Устанавливаем предпочтительный размер панели
        setPreferredSize(new Dimension(500, 400));
        setBackground(Color.WHITE); // Цвет фона панели
    }

    @Override
    protected void paintComponent(Graphics g) {
        // 1. Всегда вызывайте super.paintComponent(g) первым делом!
        // Это очищает фон панели и предотвращает артефакты отрисовки.
        super.paintComponent(g);

        // 2. Приводим Graphics к Graphics2D для доступа к расширенным функциям (сглаживание, толщина линий)
        Graphics2D g2d = (Graphics2D) g;

        // Включаем антиалиасинг (сглаживание) для красивых краев
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // --- Примеры рисования фигур ---

        // Рисуем красный заполненный прямоугольник
        g2d.setColor(Color.RED);
        g2d.fillRect(50, time%50, 150, 100); // (x, y, width, height)

        // Рисуем синий контур круга (овала)
		if(point2.x % point.x==0){
			g2d.setColor(Color.BLUE);	
			g2d.drawOval(point2.x, point2.x, 100, 100);		
		}else{
			g2d.setColor(Color.RED);
		}
        g2d.setStroke(new BasicStroke(3)); // Задаем толщину линии в 3 пикселя
        g2d.drawOval(point.x, point.y, 100, 100);   // (x, y, width, height)
	

        // Рисуем зеленую линию
        g2d.setColor(Color.GREEN);
        g2d.drawLine(50, 200, 400, 200);   // (x1, y1, x2, y2)

        // Выводим текст
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Arial", Font.BOLD, 18));
        g2d.drawString("Привет, Swing!", 50, 260); // (текст, x, y)
    }
}
	*/

class Main implements Runnable{
	public int time = 0;
	public int timeD = 0;
	private static int getTerminalProperty(String command) {
		try {
			Process process = new ProcessBuilder("/bin/sh", "-c", command + " </dev/tty").start();
			try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
				String line = reader.readLine();
				if (line != null) {
					return Integer.parseInt(line.trim());
				}
			}
		} catch (Exception e) {
			// Fallback default value if not running in a real interactive terminal
		}
		return 80; // Standard fallback default
	}

	// contructor argument
	private String word = "HELLO WORLD";
	

	// for render in terminal
	private static String text = "";


	private static int columns = getTerminalProperty("tput cols");
	private static int rows = getTerminalProperty("tput lines");

	public String http(){
		HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .build();

        // 2. Формируем запрос
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://youtube.com"))
                .GET() // Метод по умолчанию, можно опустить
                .build();

        try {
            // 3. Отправляем запрос синхронно
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // 4. Обрабатываем ответ
            System.out.println("Код статуса: " + response.statusCode());
            System.out.println("Тело ответа: \n" + response.body());
			return response.body();
        } catch (IOException | InterruptedException e) { e.printStackTrace();
		}
		return " ";
	}
	
	private char reChange(int x){
		if(text.length() > x && x-1 > 0 && text.charAt(x) == text.charAt(x-1)){
			return text.charAt(x-1);
		}
		return ' ';
	}

	private char stringNumber(int x, int y){
		char c  = Integer.toString(x).charAt(0);
		return c;
	}	

	@Override
	public void run(){
		while(this != null){
			time++;
			if (time%3 == 0){
				timeD++;
			}
			if(timeD%10==0){
				timeD+=timeD;
			}
			//String text = "";

			for(int x = 1; x < rows; x++){
				for(int y = 1; y < columns; y++){
					if(x+y > 90){
						text += stringNumber(x, y)+ " ";
					}else if(y+time < x){
						text += stringNumber(x, y)+" "; 
					}else{
						text += reChange(x) + " ";
					}
				}
				// word = "";
			}
			text += "\n";

			System.out.printf("%s\n", text);
			//text = "";
			try{
				Thread.sleep(100);
			}catch(Exception e){
				Thread.currentThread().interrupt();
			}	
		}
	}
	
	public Main(){
		new Thread(this).start();
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(Main::new);
	}
}
