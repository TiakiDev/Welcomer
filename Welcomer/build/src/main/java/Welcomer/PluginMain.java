package Welcomer;
import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.*;
import java.util.*;
import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.event.*;
import org.bukkit.plugin.java.*;

@SuppressWarnings({"unchecked", "rawtypes"})
public class PluginMain extends JavaPlugin implements Listener {

	private static PluginMain instance;

	public static Map<String, Object> globalVariables = new HashMap<>();

	public static PluginMain getInstance() {
		return instance;
	}

	@Override
	public void onEnable() {
		instance = this;
		getServer().getPluginManager().registerEvents(this, this);
		saveDefaultConfig();
		try {
			org.bukkit.Bukkit.getLogger().info("[welcomer] >>> Plugin succsesfully enabled!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			PluginMain.globalVariables.put("config",
					new java.io.File(PluginMain.getInstance().getDataFolder(), "config.yml"));
			PluginMain.globalVariables.put("configdata",
					org.bukkit.configuration.file.YamlConfiguration.loadConfiguration(
							PluginMain.resolve_object(PluginMain.globalVariables.get("config"), java.io.File.class)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onDisable() {
	}

	@Override
	public boolean onCommand(CommandSender commandSender, Command command, String label, String[] commandArgs) {
		if (command.getName().equalsIgnoreCase("welcomer")) {
			try {
				if (PluginMain.checkEquals((commandArgs.length > ((int) (0L)) ? commandArgs[((int) (0L))] : null),
						"reload")) {
					PluginMain.getInstance().reloadConfig();
					PluginMain.resolve_object(commandSender, org.bukkit.entity.Player.class).sendMessage(
							ChatColor.translateAlternateColorCodes('&', "&e [welcomer] &6>>>&f &aPlugin reloaded!"));
				}
				if (PluginMain.checkEquals((commandArgs.length > ((int) (0L)) ? commandArgs[((int) (0L))] : null),
						"test")) {
					if (PluginMain
							.resolve_object(PluginMain.getInstance().getConfig(),
									org.bukkit.configuration.file.YamlConfiguration.class)
							.getBoolean("JoinMessage.enabled")) {
						for (Object $FINAL_loopValue1 : PluginMain.resolve_object(PluginMain
								.resolve_object(PluginMain.getInstance().getConfig(),
										org.bukkit.configuration.file.YamlConfiguration.class)
								.get("JoinMessage.messages"), java.lang.Iterable.class)) {
							PluginMain.resolve_object(commandSender, org.bukkit.entity.Player.class).sendMessage(
									ChatColor.translateAlternateColorCodes('&', String.valueOf($FINAL_loopValue1)));
						}
					}
					if (PluginMain
							.resolve_object(PluginMain.getInstance().getConfig(),
									org.bukkit.configuration.file.YamlConfiguration.class)
							.getBoolean("JoinTitle.enabled")) {
						PluginMain.resolve_object(commandSender, org.bukkit.entity.Player.class).sendTitle(
								ChatColor.translateAlternateColorCodes('&',
										String.valueOf(PluginMain
												.resolve_object(PluginMain.globalVariables.get("configdata"),
														org.bukkit.configuration.file.YamlConfiguration.class)
												.get("JoinTitle.title"))),
								ChatColor.translateAlternateColorCodes('&',
										String.valueOf(PluginMain
												.resolve_object(PluginMain.globalVariables.get("configdata"),
														org.bukkit.configuration.file.YamlConfiguration.class)
												.get("JoinTitle.subtitle"))));
					}
					if (PluginMain
							.resolve_object(PluginMain.getInstance().getConfig(),
									org.bukkit.configuration.file.YamlConfiguration.class)
							.getBoolean("PlaySound.enabled")) {
						PluginMain.resolve_object(commandSender, org.bukkit.entity.Player.class).playSound(
								PluginMain.resolve_object(commandSender, org.bukkit.entity.Entity.class).getLocation(),
								org.bukkit.Sound
										.valueOf(PluginMain.getInstance().getConfig().getString("PlaySound.sound")),
								((float) PluginMain.getInstance().getConfig().getInt("PlaySound.volume")),
								((float) PluginMain.getInstance().getConfig().getInt("PlaySound.pitch")));
					}
					if (PluginMain
							.resolve_object(PluginMain.getInstance().getConfig(),
									org.bukkit.configuration.file.YamlConfiguration.class)
							.getBoolean("SpawnParticle.enabled")) {
						PluginMain.resolve_object(commandSender, org.bukkit.entity.Player.class).spawnParticle(
								org.bukkit.Particle.valueOf(
										PluginMain.getInstance().getConfig().getString("SpawnParticle.particle")),
								PluginMain.resolve_object(commandSender, org.bukkit.entity.Entity.class).getLocation(),
								PluginMain.getInstance().getConfig().getInt("SpawnParticle.count"));
					}
					if (PluginMain
							.resolve_object(PluginMain.getInstance().getConfig(),
									org.bukkit.configuration.file.YamlConfiguration.class)
							.getBoolean("JoinActionBarMessage.enabled")) {
						PluginMain.resolve_object(commandSender, org.bukkit.entity.Player.class)
								.sendActionBar(ChatColor.translateAlternateColorCodes('&',
										String.valueOf(PluginMain
												.resolve_object(PluginMain.globalVariables.get("configdata"),
														org.bukkit.configuration.file.YamlConfiguration.class)
												.get("JoinActionBarMessage.message"))));
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		}
		return true;
	}

	@Override
	public List<String> onTabComplete(CommandSender commandSender, Command command, String alias,
			String[] commandArgs) {
		if (command.getName().equalsIgnoreCase("welcomer")) {
			try {
				if (!((commandArgs.length > ((int) (0L)) ? commandArgs[((int) (0L))] : null) == null)) {
					if (!((commandArgs.length > ((int) (0L)) ? commandArgs[((int) (0L))] : null) == null)) {
						if (true)
							return PluginMain.resolve_object(new ArrayList(Arrays.asList("test")),
									java.util.List.class);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		return null;
	}

	public static void procedure(String procedure, List args) throws Exception {
	}

	public static Object function(String function, List args) throws Exception {
		return null;
	}

	public static char resolve_char(Object o) {
		return o instanceof String s ? s.charAt(0) : (char) o;
	}

	public static boolean resolve_boolean(Object o) {
		return (boolean) o;
	}

	public static byte resolve_byte(Object o) {
		return ((Number) o).byteValue();
	}

	public static short resolve_short(Object o) {
		return ((Number) o).shortValue();
	}

	public static int resolve_int(Object o) {
		return ((Number) o).intValue();
	}

	public static long resolve_long(Object o) {
		return ((Number) o).longValue();
	}

	public static float resolve_float(Object o) {
		return ((Number) o).floatValue();
	}

	public static double resolve_double(Object o) {
		return ((Number) o).doubleValue();
	}

	public static <T> T resolve_object(Object from, Class<T> to) {
		if (from == null) {
			return null;
		}
		if (to.isAssignableFrom(from.getClass())) {
			return to.cast(from);
		}
		if (from instanceof Number num && Number.class.isAssignableFrom(to)) {
			return to.cast(num.doubleValue());
		}
		if (from instanceof Collection collection && to.isArray()) {
			Object arr = Array.newInstance(to.componentType(), collection.size());
			int i = 0;
			for (Object obj : collection) {
				Array.set(arr, i++, obj);
			}
			return (T) arr;
		}
		if (from instanceof Collection collection && Collection.class.isAssignableFrom(to)) {
			Collection newCollection = getCollectionInstance(to);
			newCollection.addAll(collection);
			return (T) newCollection;
		}
		if (from.getClass().isArray() && Collection.class.isAssignableFrom(to)) {
			Collection newCollection = getCollectionInstance(to);
			for (int i = 0; i < Array.getLength(from); i++) {
				newCollection.add(Array.get(from, i));
			}
			return (T) newCollection;
		}
		return to.cast(from);
	}

	private static Collection getCollectionInstance(Class<?> type) {
		try {
			return (Collection) type.getConstructor().newInstance();
		} catch (Exception e) {
			if (List.class.isAssignableFrom(type)) {
				return new ArrayList<>();
			}
			if (Set.class.isAssignableFrom(type)) {
				return new HashSet<>();
			}
			if (Queue.class.isAssignableFrom(type)) {
				return new ArrayDeque<>();
			}
			return null;
		}
	}

	public static void createResourceFile(String path) {
		Path file = getInstance().getDataFolder().toPath().resolve(path);
		if (Files.notExists(file)) {
			try (InputStream inputStream = PluginMain.class.getResourceAsStream("/" + path)) {
				Files.createDirectories(file.getParent());
				Files.copy(inputStream, file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static boolean checkEquals(Object o1, Object o2) {
		return o1 != null ? o1.equals(o2) : false;
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void $event_AEw1EdyEGrqfpSBz(org.bukkit.event.player.PlayerJoinEvent event) throws Exception {
		if (PluginMain.resolve_object(PluginMain.getInstance().getConfig(),
				org.bukkit.configuration.file.YamlConfiguration.class).getBoolean("JoinMessage.enabled")) {
			for (Object $FINAL_loopValue1 : PluginMain.resolve_object(
					PluginMain.resolve_object(PluginMain.getInstance().getConfig(),
							org.bukkit.configuration.file.YamlConfiguration.class).get("JoinMessage.messages"),
					java.lang.Iterable.class)) {
				event.getPlayer()
						.sendMessage(ChatColor.translateAlternateColorCodes('&', String.valueOf($FINAL_loopValue1)));
			}
		}
		if (PluginMain.resolve_object(PluginMain.getInstance().getConfig(),
				org.bukkit.configuration.file.YamlConfiguration.class).getBoolean("JoinTitle.enabled")) {
			event.getPlayer().sendTitle(
					ChatColor.translateAlternateColorCodes('&',
							String.valueOf(PluginMain
									.resolve_object(PluginMain.globalVariables.get("configdata"),
											org.bukkit.configuration.file.YamlConfiguration.class)
									.get("JoinTitle.title"))),
					ChatColor.translateAlternateColorCodes('&',
							String.valueOf(PluginMain
									.resolve_object(PluginMain.globalVariables.get("configdata"),
											org.bukkit.configuration.file.YamlConfiguration.class)
									.get("JoinTitle.subtitle"))));
		}
		if (PluginMain.resolve_object(PluginMain.getInstance().getConfig(),
				org.bukkit.configuration.file.YamlConfiguration.class).getBoolean("PlaySound.enabled")) {
			event.getPlayer().playSound(
					PluginMain.resolve_object(event.getPlayer(), org.bukkit.entity.Entity.class).getLocation(),
					org.bukkit.Sound.valueOf(PluginMain.getInstance().getConfig().getString("PlaySound.sound")),
					((float) PluginMain.getInstance().getConfig().getInt("PlaySound.volume")),
					((float) PluginMain.getInstance().getConfig().getInt("PlaySound.pitch")));
		}
		if (PluginMain.resolve_object(PluginMain.getInstance().getConfig(),
				org.bukkit.configuration.file.YamlConfiguration.class).getBoolean("SpawnParticle.enabled")) {
			event.getPlayer().spawnParticle(
					org.bukkit.Particle
							.valueOf(PluginMain.getInstance().getConfig().getString("SpawnParticle.particle")),
					PluginMain.resolve_object(event.getPlayer(), org.bukkit.entity.Entity.class).getLocation(),
					PluginMain.getInstance().getConfig().getInt("SpawnParticle.count"));
		}
	}
}