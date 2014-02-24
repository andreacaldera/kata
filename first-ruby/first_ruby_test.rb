require 'test/unit'
require_relative 'first_ruby'

class FirstRubyTest < Test::Unit::TestCase

  # Called before every test method runs. Can be used
  # to set up fixture information.
  def setup
    # Do nothing
  end

  # Called after every test method runs. Can be used to tear
  # down fixture information.

  def teardown
    # Do nothing
  end

  # Fake test
  def test_first_ruby
    assert_equal(2, FirstRuby.new().plusOne(1))
  end
end