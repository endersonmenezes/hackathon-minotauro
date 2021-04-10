import random


class Maze:

    def __init__(self, width, height):
        self.width = width // 2 * 2 + 1
        self.height = height // 2 * 2 + 1
        self.cells = [
            [True for x in range(self.width)] for y in range(self.height)
        ]

    def set_path(self, x, y):
        self.cells[y][x] = False

    def set_wall(self, x, y):
        self.cells[y][x] = True

    def is_wall(self, x, y):
        if 0 <= x < self.width and 0 <= y < self.height:
            return self.cells[y][x]
        else:
            return False

    def create_maze(self, x, y):
        self.set_path(x, y)
        all_directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        random.shuffle(all_directions)
        while len(all_directions) > 0:
            direction_to_try = all_directions.pop()
            node_x = x + (direction_to_try[0] * 2)
            node_y = y + (direction_to_try[1] * 2)
            if self.is_wall(node_x, node_y):
                link_cell_x = x + direction_to_try[0]
                link_cell_y = y + direction_to_try[1]
                self.set_path(link_cell_x, link_cell_y)
                self.create_maze(node_x, node_y)
        return self.cells
